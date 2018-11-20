package screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class represents a map.
 * @author Melchor & Tori.
 * @version 1.0
 */
public class ScreenToMap extends AppCompatActivity implements View.OnClickListener {
    /**
     * The button that sends the user to the map when clicked.
     */
    Button mapButton;

    /**
     * The method is called to start and build the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_to_map);

        mapButton = findViewById(R.id.mapbutton);

        mapButton.setOnClickListener(this);


    }

    /**
     * Called when the button is clicked.
     * @param view The button that is clicked.
     */
    @Override
    public void onClick(View view) {
        if(view  == mapButton){
            Intent i = new Intent(this, TrailMap.class);
            startActivity(i);
        }

    }
}
