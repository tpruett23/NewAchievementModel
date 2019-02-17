package achievements;

import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import screens.UserCompleted;

public class Validation extends Activity {
    Context thisContext;

    String filename = "validfiles";
    String name;
    String type;
    static ArrayList<Validation> validAch;
    static UserCompleted UC;
    static UserInfo UI;
    final String messagez = "Hello Test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mMessageReceiver,
                new IntentFilter("Valid"));


    }


    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context1, Intent intent) {
            Toast.makeText(context1,"Message Received",Toast.LENGTH_LONG).show();
            String message = intent.getStringExtra("message");
            Toast.makeText(context1, message, Toast.LENGTH_LONG).show();
            Log.d("receiver", "Got message: " + message);
        }
    };




    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);


    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.
                getInstance(this).
                registerReceiver(mMessageReceiver, new IntentFilter("Valid"));
    }
}
  /*      protected void onDestroy () {
            super.onDestroy();
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(mMessageReceiver);
        }

/*
        validAch = ValidXMLHandler.getValid();

    }

    public  boolean checkValid(){
       boolean isValid = false;
  *//*     // for(int i = 0; i < validAch.size(); i++ ){
            if(validAch.get(0).type .equals("Distance")){
                if(UC.getDistanceUser() > 5){
                    isValid = true;

                    validAch.remove(0);

                }else if(UC.getDistanceUser() == 1){
                    isValid = true;
                    validAch.remove(0);
                }

            }else if(validAch.get(0).type.equals("Trails" )){
                if(UC.getTrails() > 4){
                    isValid = true;
                    validAch.remove(0);
                }
            }*//*
        //}
        Toast.makeText(this,isValid + "",Toast.LENGTH_LONG).show();
        return isValid;
    }

    public void parseXML() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlreader = saxParser.getXMLReader();


            ValidXMLHandler handler = new ValidXMLHandler();
            xmlreader.setContentHandler(handler);

            InputStream inStream = this.context.getResources().openRawResource(R.raw.validfiles);
            InputSource inStream2 = new InputSource(inStream);
            xmlreader.parse(inStream2);

        } catch (ParserConfigurationException e) {
            Toast.makeText(this, "Error reading xml file.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (SAXException e) {
            Toast.makeText(this, "Error reading xml file.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void load() {

            File extDir = new File(this.context.getFilesDir(), "validfiles");
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(extDir));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close();
                Toast.makeText(this, "Achievements Loaded", Toast.LENGTH_LONG).show();
            }//end try
            catch (FileNotFoundException e) {//If file not found on disk here.
                Toast.makeText(this, "There was no data to load", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            } catch (IOException e)//If io Exception here
            {
                Toast.makeText(this, "Error loading file", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }//end catch
            //Set the data from the file content and convert it to a String
            String data = new String(text);

            //Safety first Parse data if available.
            if (data.length() > 0) {
                parseXML();
            } else
                Toast.makeText(this, "There is no data to display", Toast.LENGTH_LONG).show();
        }//end LOAD

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }
}*/






  /*      LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(mMessageReceiver,
                new IntentFilter("push-message"));
        super.onCreate(savedInstanceState);
*/






