package achievements;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends Service {
    private Timer timer = new Timer();
    String filename = "validfiles";


    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {

        final Handler ha = new Handler();
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {
                SAXParserReader saxParserReader = new SAXParserReader(getApplicationContext());
                //saxParserReader.parseXML();
                ListViewAchv lv = new ListViewAchv();
                Toast.makeText(getApplicationContext(),"Testing",Toast.LENGTH_LONG).show();
                ha.postDelayed(this, 60000);
            }
        }, 60000);


        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }




    /**
     * The method turns the object into an xml file.
     * @return The XML String.
     */
    public String toXML() {
        String achWord = "";

        achWord +=
                "\t<name>" + "Traveled 1 Mile" + "</name>\n" +
                "\t<type>" + "Distance" + "</type>\n";


        return "<Valid\n" + achWord + "</Valid>";
    }




                private void stopService () {
                    if (timer != null) timer.cancel();
                }

                @Override
                public void onStart (Intent intent,int startid){

                    final Handler ha = new Handler();
                    ha.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            SAXParserReader saxParserReader = new SAXParserReader(getApplicationContext());
                            Toast.makeText(getApplicationContext(),"Testing",Toast.LENGTH_LONG).show();
                            ha.postDelayed(this, 10000);
                        }
                    }, 10000);


                    //   Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
                }



        }