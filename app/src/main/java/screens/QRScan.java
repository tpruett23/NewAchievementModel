package screens;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class represents the QRScanner of the application.
 * @author Tori Pruett
 * @version 1.0
 */
public class QRScan extends Activity {
    /*
    private final static int NUM = 8989;

    ImageView cameraImage;


    /**
     * The method is called to start and build the activity.
     * @param savedInstanceState
     */
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);
        cameraImage = (ImageView)findViewById(R.id.cameraimage);


        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);

        Button b = (Button)findViewById(R.id.button01);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, NUM);
            }
        });
    }
    */
/*
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NUM) {
            Bitmap image = (Bitmap) data.getExtras().get("data");

            cameraImage.setImageBitmap(image);
        }
    }
    }*/


    Button btnpic;
    ImageView imgTakenPic;
    private static final int CAM_REQUEST = 1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        btnpic = (Button) findViewById(R.id.button01);
        imgTakenPic = (ImageView) findViewById(R.id.cameraimage);
        btnpic.setOnClickListener(new btnTakePhotoClicker());
    }*/
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAM_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgTakenPic.setImageBitmap(bitmap);
        }
    }
    */
/*
    class btnTakePhotoClicker implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAM_REQUEST);
        }
    }*/
    }
}




