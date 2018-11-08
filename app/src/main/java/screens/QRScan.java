package screens;

import android.app.Activity;
import android.os.Bundle;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class represents the QRScanner of the application.
 * @author Tori Pruett
 * @version 1.0
 */
public class QRScan extends Activity {

    /**
     * The method is called to start and build the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);
    }
}
