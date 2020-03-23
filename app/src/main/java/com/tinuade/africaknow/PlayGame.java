package com.tinuade.africaknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayGame extends AppCompatActivity {
    private Button mPlayGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //widgets
        mPlayGame=findViewById(R.id.playGame);
        mPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlayGame.this,QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
