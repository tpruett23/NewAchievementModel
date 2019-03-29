package achievements;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toripruett.newachievementmodel.R;

/**
 * The class represents the question event that asks the users questions.
 * @author Tori Pruett
 * @version 1.0
 */
public class QuestionEvent extends AppCompatActivity {
    /**
     * The radio group that holds all the answer choices to the question.
     */
    RadioGroup answerGroup;
    /**
     * The textview that holds the question being asked.
     */
    TextView question;
    /**
     * The spot in the radiogroup that the correct answer choice is in.
     */
    int correctAnswerSpot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
      question = (TextView) findViewById(R.id.questions);
        answerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        correctAnswerSpot = 0;


        answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == correctAnswerSpot) {
                    Toast.makeText(getApplicationContext(), "Correct Answer!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Incorrect Answer.",Toast.LENGTH_LONG);
                }
          /*      } else if(checkedId == R.id.ans) {
                    Toast.makeText(getApplicationContext(), "choice: Sound",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "choice: Vibration",
                            Toast.LENGTH_SHORT).show();
                }*/
            }

        });

    }

    /**
     * Sets the question that is going to be asked.
     * @param question The new question being asked.
     */
    public static void setQuestion(TextView question) {
       question = question;
    }

    /**
     * Sets the correct answer spot for the chosen question.
     * @param correctAnswerSpot The correct answer position.
     */
    public static void setCorrectAnswerSpot(int correctAnswerSpot) {
       correctAnswerSpot = correctAnswerSpot;
    }
}
