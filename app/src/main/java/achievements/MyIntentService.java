package achievements;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;

import screens.TrailMap;



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

        final Handler ha=new Handler();
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {
               // testprint();
                sendMessage("Hello");

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


    public void sendMessage(final String message) {

             Intent newintent = new Intent("Valid");
             newintent.putExtra("message", message);
            // Toast.makeText(this,message,Toast.LENGTH_LONG).show();
             LocalBroadcastManager.getInstance(this).sendBroadcast(newintent);
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

        String xml_data  = toXML();

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

    /**
     * Loads the achievements from internal storage.
     *//*
    public void load() {
        File extDir = new File(this.context.getFilesDir(), filename);
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(extDir));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            Toast.makeText(this.context, "Achievements Loaded", Toast.LENGTH_LONG).show();
        }//end try
        catch (FileNotFoundException e) {//If file not found on disk here.
            Toast.makeText(this.context, "There was no data to load", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e)//If io Exception here
        {
            Toast.makeText(this.context, "Error loading file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }//end catch
        //Set the data from the file content and convert it to a String
        String data = new String(text);

        //Safety first Parse data if available.
        if (data.length() > 0) {
            parseXML();
        } else
            Toast.makeText(this.context, "There is no data to display", Toast.LENGTH_LONG).show();
    }//end LOAD*/


    public void testprint(){
        Toast.makeText(this,"Testing Service",Toast.LENGTH_LONG).show();

    }

    private void stopService () {
        if (timer != null) timer.cancel();
    }

    @Override
    public void onStart (Intent intent,int startid){

        //   Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
    }


}