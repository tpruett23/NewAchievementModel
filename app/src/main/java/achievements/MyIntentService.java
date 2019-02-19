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
                SAXParserReader saxParserReader = new SAXParserReader();
                Toast.makeText(getApplicationContext(),"Testing",Toast.LENGTH_LONG).show();
                ha.postDelayed(this, 10000);
            }
        }, 10000);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void startService() {
        SAXParserReader saxParserReader = new SAXParserReader(this);
        Validation validation = new Validation();
        //validation.add();

           /*  Intent newintent = new Intent("Valid");
             newintent.putExtra("message", message);

            // Toast.makeText(this,message,Toast.LENGTH_LONG).show();
             LocalBroadcastManager.getInstance(this).sendBroadcast(newintent);*/
             Log.d("sender", "Broadcasting message");

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


    /**
     * Save the objects as XML data to Internal Storage.
     */
    public void save() {

        String xml_data = toXML();

        //Create a file if its not already on disk
        File filesDIR = this.getFilesDir();
        File file = new File(this.getFilesDir(), "validfiles");

        FileOutputStream outputStream;//declare FOS

        try {

            outputStream = this.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(xml_data.getBytes());
            outputStream.close();

            Toast.makeText(this, "Achievements Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {//else if failed trying do this
            Toast.makeText(this, "Error saving file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }


                private void stopService () {
                    if (timer != null) timer.cancel();
                }

                @Override
                public void onStart (Intent intent,int startid){

                    //   Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
                }



        }