package achievements;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import trailsystem.Trail;

/**
 * The class represents the question event that asks the users questions.
 * @author Tori Pruett
 * @version 1.0
 */
public class QuestionEvent extends AppCompatActivity implements View.OnClickListener {
    /**
     * The textview that holds the question being asked.
     */
    static TextView question;

    RadioButton answer0, answer1, answer2, answer3;

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
        submit = (Button) findViewById(R.id.submitbutton);
        submit.setOnClickListener(this);

        answer0 = findViewById(R.id.answer0);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        answer0.setOnClickListener(this);
        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);

        question = (TextView) findViewById(R.id.questions);

        correctAnswerSpot = 1;

        allQuestions.add("Which of the following is not a trail on the WCU Trail System?");
        allQuestions.add("What is the longest trail in the WCU Trail System?");
        loadPrefs();



/*
        this.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.answer0) {
                    Toast.makeText(getApplicationContext(), "Correct Answer!",
                            Toast.LENGTH_SHORT).show();
                    Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

                    checkedId.startAnimation(shake);
                    UserCompleted.questions++;
                }else{
                    Toast.makeText(getApplicationContext(),"Incorrect Answer.",Toast.LENGTH_LONG);
                }*/
          /*      } else if(checkedId == R.id.ans) {
                    Toast.makeText(getApplicationContext(), "choice: Sound",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "choice: Vibration",
                            Toast.LENGTH_SHORT).show();
                }*/
    }

    // });

    //loadPrefs();


    /**
     * Sets the question that is going to be asked.
     *
     * @param question2 The new question being asked.
     */
    public static void setQuestion(String question2) {
        question.setText(question2);
    }

    /**
     * Sets the correct answer spot for the chosen question.
     *
     * @param correctAnswerSpot The correct answer position.
     */
    public static void setCorrectAnswerSpot(int correctAnswerSpot) {
        correctAnswerSpot = correctAnswerSpot;
    }

    public void setAnswerText() {


    }

    public void addQuestion(String text) {
        if (!allQuestions.contains(text)) {
            allQuestions.add(text);
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = saved_values.edit();
        editor.putInt("answer", v.getId());
        editor.apply();
        editor.commit();

        Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        if (correctAnswerSpot == 0) {

            Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT).show();
            answer0.startAnimation(shake);


        } else if (correctAnswerSpot == 1) {
            Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT).show();
            answer1.startAnimation(shake);

        } else if (correctAnswerSpot == 2) {

            Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT).show();
            answer2.startAnimation(shake);
        } else if (correctAnswerSpot == 3) {


            Toast.makeText(getApplicationContext(), "Correct Answer!",
                    Toast.LENGTH_SHORT).show();
            answer3.startAnimation(shake);

        }





    }

    /**
     * Loads the preferences put in by the user after being saved.
     */
    public void loadPrefs() {
        SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        int answer = saved_values.getInt("answer", 1);

        if (answer == R.id.answer1) {
            answer1.setChecked(true);
        }


    }


}
