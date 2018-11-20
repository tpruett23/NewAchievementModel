package achievements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import java.util.ArrayList;

import achievements.AchievementDescriptor;
import achievements.AchievementFactory;
import achievements.Achievements;
import achievements.CustomListAdapter;
import screens.AchievementDetails;
/******* This class takes Achievement Descriptors changed to test.

/**
 * The class puts the arraylist of all of the achievements into the listview to be displayed.
 * @author Tori Pruett
 * @version 1.0
 */
public class ListViewAchv extends AppCompatActivity {



    /**
     * Instance of the achievement class.
     **/
    //Achievements ach = new Achievements();

   // AchievementFactory AF = new AchievementFactory();


    /**
     * the arraylist of all achievements.
     **/
    private static ArrayList<Achievements> achievements;



    /**
     * The listview to display all of the achievements
     **/
    private ListView lv;


    /**
     * The adapter to put the arraylist in the listview.
     */
    ArrayAdapter<Achievements> adapter;




    /**
     * The oncreate that is called to build and start the activity.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        lv = (ListView) findViewById(R.id.list);



        achievements = AchievementXMLHandler.getAchievements();


        adapter = new CustomListAdapter(this, R.layout.list_item, R.layout.activity_list_view, achievements);

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new OnItemClickListener() {
            // argument position gives the index of item which is clicked
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                String selectedAch = achievements.get(position).getName();


                Intent myIntent = new Intent(v.getContext(), AchievementDetails.class);


                Intent data = new Intent(v.getContext(), AchievementDetails.class);

                //Achievements pos = achievements.get(position);


                data.putExtra("points", achievements.get(position).getPoints());
                data.putExtra("title", achievements.get(position).getName());
                data.putExtra("text", achievements.get(position).getDescription());


                startActivity(data);

                setResult(RESULT_OK, myIntent);

                Toast.makeText(getApplicationContext(), "Achievement Selected : " + selectedAch, Toast.LENGTH_LONG).show();

            }

        });

    }
}
