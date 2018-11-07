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


/**
 * The type List view achv.
 */
public class ListViewAchv extends AppCompatActivity {
    /**
     * The Ach.
     */
    Achievements ach = new Achievements();
    private static ArrayList<AchievementDescriptor> achievements;
    private ListView lv;


    /**
     * The Adapter.
     */
    ArrayAdapter<AchievementDescriptor> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        lv = (ListView) findViewById(R.id.list);

        AchievementFactory AF = new AchievementFactory();
        achievements = Achievements.getAllAchievements();




        adapter = new CustomListAdapter(this, R.layout.list_item, R.layout.activity_list_view, achievements);

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new OnItemClickListener() {
            // argument position gives the index of item which is clicked
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                String selectedAch = achievements.get(position).getName();


                Intent myIntent = new Intent(v.getContext(), Achievements.AchievementDetails.class);


                Intent data = new Intent(v.getContext(), Achievements.AchievementDetails.class);

                data.putExtra("points", achievements.get(position).getPoints());
                data.putExtra("title", achievements.get(position).getName());
                data.putExtra("text", achievements.get(position).getDescription());
                data.putExtra("distance", achievements.get(position).getDistance());
                startActivity(data);

                setResult(RESULT_OK, myIntent);

                Toast.makeText(getApplicationContext(), "Achievement Selected : " + selectedAch, Toast.LENGTH_LONG).show();

            }

        });

    }
}
