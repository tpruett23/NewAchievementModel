package achievements;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/**
 * The class receives messages then starts a service.
 *@author Tori Pruett
 *@version 1.0
 */
public class AlarmReciever extends BroadcastReceiver {



        /**

         * Triggered by the Alarm periodically (starts the service to run task)

         * @param context

         * @param intent

         */

        @Override

        public void onReceive(Context context, Intent intent) {


                Intent i = new Intent(context, MyIntentService.class);

                i.putExtra("foo", "AlarmReceiver");

                context.startService(i);

            }


    }

