package screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import trailsystem.MapsActivity;
import com.example.toripruett.newachievementmodel.R;

public class ScreenToMap extends AppCompatActivity implements View.OnClickListener {
    Button mapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_to_map);

        mapButton = findViewById(R.id.mapbutton);

        mapButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view  == mapButton){
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);
        }

    }
}
