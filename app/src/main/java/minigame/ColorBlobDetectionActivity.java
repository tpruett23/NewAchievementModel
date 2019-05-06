package minigame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.toripruett.newachievementmodel.R;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.List;

public class ColorBlobDetectionActivity extends Activity implements View.OnTouchListener, CameraBridgeViewBase.CvCameraViewListener2 {
    private static final String TAG = "color-detection";

    /** boolean to check if a color is selected */
    private boolean mIsColorSelected = false;
    /** single-channel array to store a single color image */
    private Mat mRgba;
    /** 4-element vector to hold RGB values */
    private Scalar mBlobColorRgba;
    /** 4-element vector to hold HSV values*/
    private Scalar mBlobColorHsv;
    /** detector of color chosen*/
    private ColorBlobDetector mDetector;
    /** multi-channel array to store a spectrum of color*/
    private Mat mSpectrum;
    /** template to hold size of contour color*/
    private Scalar contour_color;
    /** template to hold size of contour color*/
    private Size spectrum_size;
    private Scalar lowerLimit;
    private Scalar upperLimit;

    /** class implementing the interaction with Camera and OpenCV library*/
    private static CameraBridgeViewBase mOpenCVCameraView;

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this ) {
        /**
         * Callback method, called after OpenCV library initialization
         * @param status - status of initialization
         */
        @Override
        public void onManagerConnected(int status) {
            switch (status){
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.v(TAG, "OpenCV loaded successfully");
                    mOpenCVCameraView.enableView();
                    mOpenCVCameraView.setOnTouchListener(ColorBlobDetectionActivity.this);
                } break;
                default: {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

    public ColorBlobDetectionActivity(){
        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    /**
     * Called when the activity is first created.
     * @param savedInstanceState - if the activity is being re-initialized after previously being
     *                           shut down then this Bundle contains the data it most recently supplied
     *                           in OnSaveInstanceState(Bundle)
     *                           Note: otherwise it is null.
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG, "called onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.color_blob_detection_surface_view);

        mOpenCVCameraView = findViewById(R.id.color_blob_detection_surface_view);
        mOpenCVCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCVCameraView.setCvCameraViewListener(this);
    }

    /**
     * Called as a part of the activity lifecycle when an activity is going into the background,
     * but has not (yet) been killed.
     */
    @Override
    public void onPause(){
        super.onPause();
        if(mOpenCVCameraView != null){
            mOpenCVCameraView.disableView();
        }
    }

    /**
     * Called after onRestoreInstanceState(Bundle), onRestart(), or onPause()
     * for your activity to start interacting with the user. This is a good place to begin
     * animations, open exclusive-access devices (such as camera), etc.
     */
    @Override
    public void onResume(){

        super.onResume();
        if(!OpenCVLoader.initDebug()){
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this,mLoaderCallback);
        }else{
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    /**
     * Perform any final cleanup before an activity is destoryed. This can happen either because
     * the activity is finishing (someone called finish() on it), or because the system is
     * temporarily destroying this instance of the activity to save space. You can distinguish
     * between these two scenarios with the isFinishing
     */
    public void onDestroy(){
        super.onDestroy();
        if(mOpenCVCameraView != null){
            mOpenCVCameraView.disableView();
        }
    }

    /**
     * This method is invoked when camera preview has started. After this method
     * is invoked the frames will start to be delivered to client via
     * onCameraFrame() callback
     * @param width -  the width of the frames that will be delivered
     * @param height - the height of the frames that will be delivered
     */
    public void onCameraViewStarted(int width, int height){
        mRgba = new Mat(height, width, CvType.CV_8UC4);
        mDetector = new ColorBlobDetector();
        mSpectrum = new Mat();
        mBlobColorRgba = new Scalar(255);
        mBlobColorHsv = new Scalar(255);
        spectrum_size = new Size(200,64);
        contour_color = new Scalar(255,0,0,255);
    }

    /**
     * This method is invoked when camera preview has been stopped for some reason.
     * No frames will be delivered via onCameraFrame() callback after this method is called.
     */
    public void onCameraViewStopped(){
        mRgba.release();
    }

    /**
     * Called when a touch event is dispatched to a view. This allows listeners to get a chance to
     * respond before the target view.
     * @param v - The view the touch event has been dispatched to.
     * @param event - The MotionEvent object containing full information about the event
     * @return - True is the listner has consumed the event, false otherwise
     */
    public boolean onTouch(View v, MotionEvent event){
        int cols = mRgba.cols();
        int rows = mRgba.rows();

        int xOffset = (mOpenCVCameraView.getWidth() - cols)/2;
        int yOffSet = (mOpenCVCameraView.getHeight()-rows)/2;

        int x = (int)event.getX() - xOffset;
        int y = (int)event.getY() - yOffSet;

        Log.i(TAG, "Touch image coordinates (" + x + ", " + y + ")");

        if((x < 0) || (y < 0) || (x > cols) || (y > rows)) return false;

        Rect touchedRect = new Rect();

        touchedRect.x = (x>4) ? x-4 : 0;
        touchedRect.y = (y>4) ? y-4 : 0;

        touchedRect.width = (x+4 < cols) ? x + 4 - touchedRect.x : cols - touchedRect.x;
        touchedRect.height = (y+4 < rows) ? y + 4 - touchedRect.y : rows - touchedRect.y;

        Mat touchedRegionRgba = mRgba.submat(touchedRect);

        Mat touchedRegionHsv = new Mat();
        Imgproc.cvtColor(touchedRegionRgba, touchedRegionHsv, Imgproc.COLOR_RGB2HSV_FULL);

        // Calculate average color of touched region
        mBlobColorHsv = Core.sumElems(touchedRegionHsv);
        int pointCount = touchedRect.width*touchedRect.height;
        for (int i = 0; i < mBlobColorHsv.val.length; i++)
            mBlobColorHsv.val[i] /= pointCount;

        mBlobColorRgba = convertScalarHsv2Rgba(mBlobColorHsv);

        Log.i(TAG, "Touched rgba color: (" + mBlobColorRgba.val[0] + ", " + mBlobColorRgba.val[1] +
                ", " + mBlobColorRgba.val[2] + ", " + mBlobColorRgba.val[3] + ")");
        Log.i(TAG, "Touched hsv color: (" + mBlobColorHsv.val[0] + ", " + mBlobColorHsv.val[1] +
                ", " + mBlobColorHsv.val[2] + ", " +  ")");

        mDetector.setHsvColor(mBlobColorHsv);

        Imgproc.resize(mDetector.getSpectrum(), mSpectrum, spectrum_size, 0, 0, Imgproc.INTER_LINEAR_EXACT);

        mIsColorSelected = true;

        touchedRegionRgba.release();
        touchedRegionHsv.release();

        return false; // don't need subsequent touch events

    }

    /**
     * This method is invoked when delivery of a frame needs to be done.
     * @param inputFrame - specified format of the frame (RGB)
     * @return - a modified frame which needs to be displayed on the screen.
     */
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();

        if (mIsColorSelected) {
            mDetector.process(mRgba);

            boolean check = checkGreen();
            if(check == true){
                //Toast.makeText(this, "Some green has been found", Toast.LENGTH_LONG).show();
                Log.v("color-check", "green has been detected");
                this.onDestroy();
            }

            List<MatOfPoint> contours = mDetector.getContours();
            Log.e(TAG, "Contours count: " + contours.size());
            Imgproc.drawContours(mRgba, contours, -1, contour_color);

            Mat colorLabel = mRgba.submat(4, 68, 4, 68);
            colorLabel.setTo(mBlobColorRgba);

            Mat spectrumLabel = mRgba.submat(4, 4 + mSpectrum.rows(), 70, 70 + mSpectrum.cols());
            mSpectrum.copyTo(spectrumLabel);
        }

        return mRgba;
    }

    private void setLimits(Scalar lowerLimit, Scalar upperLimit){
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    private boolean checkLimit(){
        for(int i = 0; i< mBlobColorHsv.val.length; i++){
            if(mBlobColorHsv.val[i] > upperLimit.val[i] || mBlobColorHsv.val[i] < lowerLimit.val[i])
                return false;
        }
        return true;
    }

    private boolean checkGreen(){
        double sensitivity = 40;
        if(mBlobColorHsv.val[0] > 60 + sensitivity || mBlobColorHsv.val[0] < 60 - sensitivity){
            return false;
        }
        if(mBlobColorHsv.val[1] > 255 || mBlobColorHsv.val[1] < 100){
            return  false;
        }
        return !(mBlobColorHsv.val[2] > 255) && !(mBlobColorHsv.val[2] < 100);
    }

    private Scalar convertScalarHsv2Rgba(Scalar hsvColor) {
        Mat pointMatRgba = new Mat();
        Mat pointMatHsv = new Mat(1, 1, CvType.CV_8UC3, hsvColor);
        Imgproc.cvtColor(pointMatHsv, pointMatRgba, Imgproc.COLOR_HSV2RGB_FULL, 4);

        return new Scalar(pointMatRgba.get(0, 0));
    }

}
