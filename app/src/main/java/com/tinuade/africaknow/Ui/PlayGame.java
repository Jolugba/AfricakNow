package com.tinuade.africaknow.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tinuade.africaknow.R;

public class PlayGame extends AppCompatActivity {
    private Button mPlayGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //widgets
        mPlayGame = findViewById(R.id.playGame);
        mPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayGame.this, QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
