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
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;

public class ColorBlobDetectionActivity extends Activity implements View.OnTouchListener, CvCameraViewListener2 {
    private static final String TAG = "color detection";

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

    /** class implementing the interaction with Camera and OpenCV library*/
    private CameraBridgeViewBase mOpenCVCameraView;

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
                    Log.i(TAG, "OpenCV loaded successfully");
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
        Log.i(TAG, "called onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.color_blob_detection_surface_view);
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
        if(OpenCVLoader.initDebug()){
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this,mLoaderCallback);
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


    }

}
