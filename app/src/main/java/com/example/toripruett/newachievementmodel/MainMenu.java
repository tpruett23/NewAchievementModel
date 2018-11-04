package com.example.toripruett.newachievementmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements OnClickListener{

    Button storyButton;
    Button miniGameButton;
    Toolbar toolbar;


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

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





