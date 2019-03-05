package achievements;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;


/**
 * The class is a service that checks for new achievements.
 */
public class MyIntentService extends Service {


    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {

        final Handler ha = new Handler(getApplicationContext().getMainLooper());
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {
                //SAXParserReader saxParserReader = new SAXParserReader(getApplicationContext());
                AchievementXMLHandler achievementXMLHandler = new AchievementXMLHandler();
                achievementXMLHandler.checkAll();
                ListViewAchv L = new ListViewAchv();
                Toast.makeText(getApplicationContext(),"Testing",Toast.LENGTH_LONG).show();
                ha.postDelayed(this, 60000);

            }
        }, 60000);


        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}