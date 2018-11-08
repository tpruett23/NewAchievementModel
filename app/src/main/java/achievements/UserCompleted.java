package achievements;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.toripruett.newachievementmodel.R;

import java.util.ArrayList;

public class UserCompleted extends AppCompatActivity {
    /**
     * The Listview that displays the completed achievements.
     */
    private ListView lv;

    /**
     * The number of trails that have been completed by the user.
     */
    private int trails = 4;

    /**
     * The number of questions that have answered correctly by the user.
     */
    private int questionsCorrect = 11;

    /**
     * The number of questions that have been answered incorrectly.
     */
    private int questionsIncorrect = 2;

    /**
     * The number of achievements won by the user.
     */
    private int achievementsWon = 3;

    /**
     * The number of challenges met by the user.
     */
    private int challenges = 4;

    /**
     * The arraylist to hold all of the completed achievements.
     */
    ArrayList<AchievementDescriptor> completed = UserInfo.getCompleted();

    /**
     * The adapter to display the arraylist.
     */
    ArrayAdapter<AchievementDescriptor> adapter;

    /**
     * The method that is called to start and build the activity.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.usertrophycabinet);


        lv = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, R.layout.userlist, R.layout.activity_list_view, completed);

        lv.setAdapter(adapter);
    }

    /**
     * Gets the number of trails completed.
     *
     * @return The number of trails.
     */
    public int getTrails() {
        return this.trails;
    }

    /**
     * Gets the number of challenges completed.
     *
     * @return Number of challenges.
     */
    public int getChallenges() {
        return challenges;
    }

    /**
     * Gets the number of questions answered correctly.
     *
     * @return The questions answered correctly.
     */
    public int getQuestionsCorrect() {
        return questionsCorrect;
    }

    /**
     * Gets the number of questions answered incorrectly.
     *
     * @return The number of questions answered incorrectly.
     */
    public int getQuestionsIncorrect() {
        return questionsIncorrect;
    }

    /**
     * Gets the amount of achievements won.
     *
     * @return The amount of achievements won.
     */
    public int getAchievementsWon() {
        return achievementsWon;
    }

    /**
     * Gets the arraylist of completed achievements.
     *
     * @return the arraylist of completed achievements.
     */
    public ArrayList<AchievementDescriptor> getCompleted() {
        return this.completed;
    }
}






