package screens;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.example.toripruett.newachievementmodel.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class displays facts along the trail system
 * @author Tori Pruett
 * @version 1.0
 */
public class Facts extends AppCompatActivity{
    /**
     * The collection of facts to display.
     */
    public static List<String> facts;
    /**
     * The notification manager to display the message.
     */
    NotificationManager mNotificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facts = new ArrayList<>();

        facts.add("The WCU Trail System contains a sculpture called Dirtmaker that " +
                "replenishes minerals in the forest's soil. The sculpture was created in 2016.");
        facts.add("The colored markings on some of the trees along the trail, correlate with " +
                "the trail color on the trail map to inform you of what trail you are on.");
        facts.add("The Cullowhee Connector is the longest trail in the WCU Trail System and the " +
                "shortest trail is the Corkscrew Trail.");

        openDialog();
    }

    /**
     * The method that is called to display the alert box that contains the message.
     */
    public void openDialog() {

        Random randomNum = new Random();
        String random = facts.get(randomNum.nextInt(facts.size()));


        new AlertDialog.Builder(this, R.style.UserDialog)
                .setTitle("Fun Fact:")
                .setMessage(random)
                .setIcon(R.drawable.smiley)
                .setCancelable(false)
                .setPositiveButton("Cool!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dialog.cancel();
                        finish();

                    }
                })
                .create()
                .show();


    }


}
