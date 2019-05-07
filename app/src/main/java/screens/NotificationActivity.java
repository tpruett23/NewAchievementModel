package screens;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/**
 * Activity to send a notification.
 * @author Tori Pruett
 */
public class NotificationActivity extends Activity {
        /**
         * Notification ID.
         */
        public static final String NOTIFICATION_ID = "NOTIFICATION_ID";
        /**
         * This is called to create the activity before it is started.
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.cancel(getIntent().getIntExtra(NOTIFICATION_ID, -1));
            finish(); // since finish() is called in onCreate(), onDestroy() will be called immediately
        }
        /**
         * Gets the pending intent and sends the notification by using an intent.
         * @param notificationId The id of the notification.
         * @param context The context to create the intent.
         * @return Returns the dismiss intent.
         */
        public static PendingIntent getDismissIntent(int notificationId, Context context) {
            Intent intent = new Intent(context, NotificationActivity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //intent.putExtra(NOTIFICATION_ID, notificationId);*/
            PendingIntent dismissIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            return dismissIntent;
        }


    }

