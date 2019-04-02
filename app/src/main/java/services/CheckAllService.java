package services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import achievements.AchievementXMLHandler;
import achievements.ListViewAchv;

/**
 * @author Tori Pruett
 * Service to check to see if any new achievements have been met.
 */
public class CheckAllService extends Service {
    public CheckAllService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * When the service is started this calls the method to check all the achievements.
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AchievementXMLHandler.checkAll();
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onStart(Intent intent, int startId) {
        AchievementXMLHandler.checkAll();
        super.onStart(intent, startId);
    }
}
