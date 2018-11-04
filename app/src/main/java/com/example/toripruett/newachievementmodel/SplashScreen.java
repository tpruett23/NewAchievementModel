package com.example.toripruett.newachievementmodel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {


    private final int DELAY = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }


    public void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(runner, DELAY);
    }


    private final Runnable runner = new Runnable() {
        @Override
        public void run() {
            nextScreen();

        }
    };


    private void nextScreen() {
        Intent i = new Intent(this, MainMenu.class);
        this.startActivity(i);
        this.finish();

    }
}
