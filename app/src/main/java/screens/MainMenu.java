package screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import achievements.ListViewAchv;
import com.example.toripruett.newachievementmodel.R;
import achievements.Settings;
import achievements.UserCompleted;

/**
 * This represents the main menu of the application.
 * @author Tori Pruett
 * @version 1.0
 */
public class MainMenu extends AppCompatActivity implements OnClickListener{
    /**
     * This button takes the user to the story mode screen.
     **/
    Button storyButton;

    /**
     * This button takes the user to the mini game screen.
     **/
    Button miniGameButton;

    /**
     * This represents the toolbar that is displayed on the main menu.
     **/
    Toolbar toolbar;

    /**
     * The method is called whenever this activity is created to assign values and build.
     * @param savedInstanceState
     */
    //===========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storyButton = (Button)findViewById(R.id.storyButton);
        miniGameButton = (Button)findViewById(R.id.miniButton);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        storyButton.setOnClickListener(this);
        miniGameButton.setOnClickListener(this);

    }//==========================================================

    /**
     * This method inflates the toolbar on the screen.
     * @param menu The toolbar to inflate.
     * @return returns true if successful.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * This is the method called when one of the buttons in the toolbar is clicked.
     * @param item The item in the toolbar.
     * @return returns true if successful.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = null;
        switch (item.getItemId()) {
            case R.id.action_rib:
                i = new Intent(this, ListViewAchv.class);
                startActivity(i);
                return true;
            case R.id.action_cam:
                i = new Intent(this, QRScan.class);
                startActivity(i);
                return true;
            case R.id.completed:
                i = new Intent(this,UserCompleted.class);
                startActivity(i);
                return true;
            case R.id.Settings:
                i = new Intent(this, Settings.class);
                startActivity(i);
                return true;
        }


        return super.onOptionsItemSelected(item);

    }

    /**
     * The method that is called when the other buttons not in the toolbar are called.
     * @param v The button that is clicked.
     */
    public void onClick(View v){
        Intent i;
        if(v.getId() == storyButton.getId()){
            i = new Intent(this,Story.class);
            startActivity(i);
        }else if(v.getId() == miniGameButton.getId()){
            i = new Intent(this,MiniGame.class);
            startActivity(i);

        }

    }
}





