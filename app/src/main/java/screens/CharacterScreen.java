package screens;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toripruett.newachievementmodel.R;

import java.util.LinkedList;

public class CharacterScreen extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    TextView textView;
    public static LinkedList<String> dialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.character_screen);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        textView.setOnClickListener(this);
        textView.setText(dialogue.pop());
    }

    @Override
    public void onClick(View view) {
        if(!dialogue.isEmpty()){
            textView.setText(dialogue.pop());
        }else{
            this.finish();
        }
    }

}
