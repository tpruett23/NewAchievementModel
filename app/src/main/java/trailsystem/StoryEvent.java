package trailsystem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StoryEvent extends PointOfInterest {
    String filename = "character1-1";
    Context context;


    public StoryEvent(Context context) {
        this.context = context;

    }


    public void createFile() {
        //Create a file if its not already on disk
        File filesDIR = this.context.getFilesDir();
        File file = new File(this.context.getFilesDir(), filename);
        String data = null;





        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                data = scan.next();


            }





            Toast.makeText(this.context, "Achievements Saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this.context, "Error loading file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {//else if failed trying do this
            Toast.makeText(this.context, "Error loading file", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    class CharacterScreen extends AppCompatActivity{
        TextView text;
        TextWatcher tw;

        public CharacterScreen(){
            text = (TextView)findViewById(R.id.textView);
            tw = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            };

            text.addTextChangedListener(tw);
        }
    }
}
