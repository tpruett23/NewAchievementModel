package services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

public class ServiceConnectionHelper implements ServiceConnection {

    /** Messenger for communicating with the service */
    Messenger mService = null;


    /**
     * Called when a connection to the Service has been established, with the IBinder
     * of the communication channel to the Service.
     * @param componentName - The concrete component name of the service that has been
     *                      connected
     * @param service - The IBinder of the Service's communication channel, which you
     *                can now make calls on.
     */
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {
        mService = new Messenger(service);
    }

    /**
     * Called when a connection to the Service has been lost. This typically happens
     * when the process hosting the service crashed or been killed. This doe not
     * remove the ServiceConnection itself -- this binding to the service will remain
     * active, and you will receive a call to onServiceConnected(ComponentName, IBinder)
     * when the Service is next running.
     * @param componentName - The concrete component name of the service whose connection
     *                      has been lost.
     */
    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mService = null;
    }

    /**
     * Return the messenger for the corresponding service
     * @return - Messenger for the service.
     */
    public Messenger getMessenger(){
        return mService;
    }
}
