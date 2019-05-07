package achievements;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import java.util.ArrayList;

import achievements.AchievementDescriptor;
import achievements.AchievementFactory;
import achievements.Achievements;
import achievements.CustomListAdapter;
import screens.AchievementDetails;
import screens.UserCompleted;


/**
 * The class puts the arraylist of all of the achievements into the listview to be displayed.
 * @author Tori Pruett
 * @version 1.0
 */
public class ListViewAchv extends AppCompatActivity {
    /**
     * The arraylist of all achievements.
     **/
    private ArrayList<Achievements> achievements;
    /**
     * The listview to display all of the achievements
     **/
    private ListView lv;
    /**
     * The total points the user has received.
     */
    static TextView totalPoints;
    /**
     * The adapter to put the arraylist in the listview.
     */
    ArrayAdapter<Achievements> adapter;
    /**
     * Achievement factory instance to access certain methods and variables.
     */
    AchievementFactory AF = new AchievementFactory();


    /**
     * The onCreate that is called to build and start the activity.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        totalPoints = findViewById(R.id.pointtextview);
        totalPoints.setText("Total Points: " + UserInfo.totalPoints);

        lv = findViewById(R.id.list);

        achievements = AchievementFactory.achievements;

        adapter = new CustomListAdapter(this, R.layout.list_item, R.layout.activity_list_view, achievements);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new OnItemClickListener() {
            // argument position gives the index of item which is clicked
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {


                String selectedAch = achievements.get(position).getName();

                Intent myIntent = new Intent(v.getContext(), AchievementDetails.class);

                Intent data = new Intent(v.getContext(), AchievementDetails.class);

                data.putExtra("points", achievements.get(position).getPoints());
                data.putExtra("title", achievements.get(position).getName());
                data.putExtra("text", achievements.get(position).getDescription());
                data.putExtra("achDesA",achievements.get(position).getDescriptorA().getName());
                //adapter.isEnabled(position);

                startActivity(data);

                setResult(RESULT_OK, myIntent);

                Toast.makeText(getApplicationContext(), "Achievement Selected : " + selectedAch, Toast.LENGTH_LONG).show();

            }

        });

    }
    /**
     * Method to set the total points the user has.
     * @param text the points we are setting total points to.
     */
    public static void setTotalPoints(String text){
       totalPoints.setText(text);
    }

}
