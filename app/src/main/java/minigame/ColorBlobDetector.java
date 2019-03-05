package minigame;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class ColorBlobDetector {
    /** Lower and Upper bounds for range checking in HSV color space */
    private Scalar mLowerBound = new Scalar(0);
    private Scalar mUpperBound = new Scalar(0);
    /** Minimum contour area in percent for contours filtering */
    private static double mMinContourArea = 0.1;
    /** Color radius for range checking in HSV color space*/
    private Scalar mColorRadius = new Scalar(25, 50, 50, 0);
    private Mat mSpectrum = new Mat();
    private List<MatOfPoint> mContours = new ArrayList<>();

    /** Cache */
    Mat mPyrDownMat = new Mat();
    Mat mHSVMat = new Mat();
    Mat mMask = new Mat();
    Mat mDilatedMask = new Mat();
    Mat mHierarchy = new Mat();

    /**
     * Set the color radius nn the HSV color space
     * @param radius - new radius
     */
    public void setColorRadius(Scalar radius){
        mColorRadius = radius;
    }

    public void setHsvColor(Scalar hsvColor){
        double minH = (hsvColor.val[0]) >= mColorRadius.val[0] ? hsvColor.val[0]-mColorRadius.val[0] : 0;
        double maxH = (hsvColor.val[0]+mColorRadius.val[0] <= 255) ? hsvColor.val[0]+mColorRadius.val[0]:255;

        mLowerBound.val[0] = minH;
        mUpperBound.val[0] = maxH;

        mLowerBound.val[1] = hsvColor.val[1] - mColorRadius.val[1];
        mUpperBound.val[1] = hsvColor.val[1] + mColorRadius.val[1];

        mLowerBound.val[2] = hsvColor.val[2] - mColorRadius.val[2];
        mUpperBound.val[2] = hsvColor.val[2] - mColorRadius.val[2];

        mLowerBound.val[3] = 0;
        mUpperBound.val[3] = 255;

        Mat spectrumHsv = new Mat(1, (int) (maxH-minH), CvType.CV_8UC3);

        for(int j =0; j < maxH-minH; j++){
            byte[] tmp = {(byte)(minH+j),(byte)255,(byte)255};
            spectrumHsv.put(0,j,tmp);
        }

        Imgproc.cvtColor(spectrumHsv,mSpectrum,Imgproc.COLOR_HSV2BGR_FULL, 4);
    }

    public Mat getmSpectrum(){
        return mSpectrum;
    }

    public void setMinContourArea(double area){
        mMinContourArea = area;
    }

    public void process(Mat rgbaImage){

    }

}
