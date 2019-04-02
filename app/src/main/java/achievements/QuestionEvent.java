package achievements;

import android.content.Intent;
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

import java.lang.reflect.Array;
import java.util.ArrayList;

import screens.TrailMap;
import screens.UserCompleted;

/**
 * The class represents the question event that asks the users questions.
 * @author Tori Pruett
 * @version 1.0
 */
public class QuestionEvent extends AppCompatActivity implements View.OnClickListener {
    /**
     * The radio group that holds all the answer choices to the question.
     */
    RadioGroup answerGroup;
    /**
     * The textview that holds the question being asked.
     */
    static TextView question;

    String askedQuestion;
    /**
     * The spot in the radiogroup that the correct answer choice is in.
     */
    int correctAnswerSpot;
    /**
     * Button to submit the answer choice.
     */
    Button submit;
    /**
     * Arraylist that holds all of questions that the user could be asked.
     */
    ArrayList<String> allQuestions = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
        submit = (Button)findViewById(R.id.submitbutton);
        submit.setOnClickListener(this);


        question = (TextView) findViewById(R.id.questions);
        answerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        correctAnswerSpot = 1;

        allQuestions.add("Which of the following is not a trail on the WCU Trail System?");
        allQuestions.add("What is the longest trail in the WCU Trail System?");



        answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == correctAnswerSpot) {
                    Toast.makeText(getApplicationContext(), "Correct Answer!",
                            Toast.LENGTH_SHORT).show();
                    UserCompleted.questions++;
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
     * @param question2 The new question being asked.
     */
    public static void setQuestion(String question2) {
       question.setText(question2);
    }

    /**
     * Sets the correct answer spot for the chosen question.
     * @param correctAnswerSpot The correct answer position.
     */
    public static void setCorrectAnswerSpot(int correctAnswerSpot) {
       correctAnswerSpot = correctAnswerSpot;
    }

    public void addQuestion(String text){
        if(!allQuestions.contains(text)) {
            allQuestions.add(text);
        }
    }

    @Override
    public void onClick(View v) {
    if(v.getId() == R.id.submitbutton){
        Intent i = new Intent(this, TrailMap.class);
        startActivity(i);
    }
    }
}
