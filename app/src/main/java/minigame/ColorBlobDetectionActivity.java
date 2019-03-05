package minigame;

import android.app.Activity;
import android.view.View;

import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

public class ColorBlobDetectionActivity extends Activity implements View.OnTouchListener, CvCameraViewListener2 {
private static final String TAG = "color detection";

/** boolean to check if a color is selected */
private boolean mIsColorSelected = false;
/** single-channel array to store a single color image */
private Mat mRgba;
/** 4-element vector to hold RGB values */
private Scalar mBlobColorRgba;
/** detector of color chosen*/
private ColorBlobDetector mDetector;
/** */

}
