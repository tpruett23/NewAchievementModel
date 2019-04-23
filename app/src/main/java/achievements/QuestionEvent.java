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
    /**
     * All of the radiobuttons that hold the answer choices.
     */
    RadioButton answer0, answer1, answer2, answer3;
    /**
     * The question being asked.
     */
    String askedQuestion;
    /**
     * The spot in the radiogroup that the correct answer choice is in.
     */
    int correctAnswerSpot;

    /**
     * Animation that makes the buttons shake.
     */
    Animation shake;
    /**
     * Arraylist that holds all of questions that the user could be asked.
     */
    ArrayList<String> allQuestions = new ArrayList<>();
    /**
     * Arraylist that holds all of answers that could be used.
     */
    ArrayList<String> allAnswers = new ArrayList<>();
    /**
     * The arraylist that is full of the radiobuttons that correspond to the answers.
     */
    ArrayList<RadioButton> answerButtons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);




        shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

        answer0 = findViewById(R.id.answer0);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        answer0.setOnClickListener(this);
        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);

        answerButtons.add(answer0);
        answerButtons.add(answer1);
        answerButtons.add(answer2);
        answerButtons.add(answer3);

        allAnswers.add("Coffee Shop");
        allAnswers.add("Corkscrew");
        allAnswers.add("HHS Connector");
        allAnswers.add("Catamount Gap");

        answer0.setText(allAnswers.get(0));
        answer1.setText(allAnswers.get(1));
        answer2.setText(allAnswers.get(2));
        answer3.setText(allAnswers.get(3));

        allQuestions.add("What trail are we currently on?");

        question = (TextView) findViewById(R.id.questions);
        setQuestion(allQuestions.get(0));


        correctAnswerSpot = 0;




    }


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


    /**
     * Adds a new question to be asked to the arraylist.
     * @param text The question to be added.
     */
    public void addQuestion(String text) {
        if (!allQuestions.contains(text)) {
            allQuestions.add(text);
        }
    }

    /**
     * Method that is called when an answer choice has been clicked.
     * @param v The answer choice or radio button that was clicked.
     */
    @Override
    public void onClick(View v) {
        int spot = v.getId();
        if (v.getId() == answerButtons.get(correctAnswerSpot).getId()) {
            RadioButton temp = answerButtons.get(correctAnswerSpot);
            v.startAnimation(shake);
            UserCompleted.setQuestions(1);
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Incorrect Answer!", Toast.LENGTH_LONG).show();
        }

        for (int i = 0; i < answerButtons.size(); i++) {
            if (i != spot) {
                answerButtons.get(i).setEnabled(false);
            }
        }
    }

    public void setAnswers(String a, String b, String c, String d){
        allAnswers.add(a);
        allAnswers.add(b);
        allAnswers.add(c);
        allAnswers.add(d);

        answer0.setText(a);
        answer1.setText(b);
        answer2.setText(c);
        answer3.setText(d);
    }





}
