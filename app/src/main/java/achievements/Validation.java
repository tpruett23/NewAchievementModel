package achievements;

import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.drm.DrmStore;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /*private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context1, Intent intent) {
            Toast.makeText(context1, "Message Received", Toast.LENGTH_LONG).show();
            String message = intent.getStringExtra("message");
            Toast.makeText(context1, message, Toast.LENGTH_LONG).show();
            Log.d("receiver", "Got message: " + message);
        }
    };*/


    public void testAdd(Achievements ach) {

        AchievementFactory.achievements.add(ach);
    }


   /* @Override
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
*/
  /*  private MyService2 myServiceBinder;
    public ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder binder) {
            myServiceBinder = ((MyService2.MyBinder) binder).getService();
            Log.d("ServiceConnection","connected");
            showServiceData();
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.d("ServiceConnection","disconnected");
            myService2 = null;
        }
    };

    public Handler myHandler = new Handler() {
        public void handleMessage(Message message) {
            Bundle data = message.getData();
        }
    };

    public void doBindService() {
        Intent intent = null;
        intent = new Intent(this, BTService.class);
        // Create a new Messenger for the communication back
        // From the Service to the Activity
        Messenger messenger = new Messenger(myHandler);
        intent.putExtra("MESSENGER", messenger);

        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume() {

        Log.d("activity", "onResume");
        if (myService2 == null) {
            doBindService();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        //FIXME put back

        Log.d("activity", "onPause");
        if (myService2 != null) {
            unbindService(myConnection);
            myService2 = null;
        }
        super.onPause();
    }

*/

}


