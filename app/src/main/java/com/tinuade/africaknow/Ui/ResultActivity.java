package com.tinuade.africaknow.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tinuade.africaknow.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int score = intent.getIntExtra(QuestionActivity.EXTRA_TEXT, 0);
        TextView textView2 = findViewById(R.id.result);
        textView2.setText("YOUR DEMO SCORE IS: " + score);
    }
}
