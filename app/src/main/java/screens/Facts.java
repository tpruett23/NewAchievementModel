package screens;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;
import com.google.android.gms.common.internal.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.toripruett.newachievementmodel.R.*;

public class Facts extends AppCompatActivity{
    public static List<String> facts;
    NotificationManager mNotificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.facts = new ArrayList<>();


        facts.add("The WCU Trail System contains a sculpture called Dirtmaker that " +
                "replenishes minerals in the forest's soil. The sculpture was created in 2016.");
        facts.add("The colored markings on some of the trees along the trail, correlate with " +
                "the trail color on the trail map to inform you of what trail you are on.");

        Random randomNum = new Random();
        String random = facts.get(randomNum.nextInt(facts.size()));
        openDialog(random);
    }

    public void openDialog(String messageBody) {

        Random randomNum = new Random();
        String random = facts.get(randomNum.nextInt(facts.size()));


        new AlertDialog.Builder(this, R.style.UserDialog)
                .setTitle("Fun Fact:")
                .setMessage(random)
                .setIcon(R.drawable.smiley)
                .setCancelable(false)
                .setPositiveButton("Cool!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dialog.cancel();

                    }
                })
               .create()
                .show();

       }




}
