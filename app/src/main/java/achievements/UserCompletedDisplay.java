package achievements;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.toripruett.newachievementmodel.R;
import java.util.ArrayList;

/**
 * Displays the users completed achievements in a listview.
 * @author Tori Pruett
 * @version 2.0
 */

public class UserCompletedDisplay extends Activity {
    /**
     * The Listview that displays the completed achievements.
     */
    private ListView lv;
    /**
     * The arraylist to hold the completed achievements for the user.
     */
    private ArrayList<Achievements> completed;
    /**
     * The adapter to display the arraylist.
     */
    ArrayAdapter<Achievements> adapter;
    /**
     * The method that is called to start and build the activity.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.usertrophycabinet);
        lv = findViewById(R.id.list);
        adapter = new CustomListAdapter(this, R.layout.userlist, R.layout.activity_list_view, completed);
        lv.setAdapter(adapter);
    }
    /**
     * Gets all of the completed achievements arraylist.
     * @return The arraylist of achievements.
     */
    public ArrayList<Achievements> getCompleted() {
        return this.completed;
    }
}
