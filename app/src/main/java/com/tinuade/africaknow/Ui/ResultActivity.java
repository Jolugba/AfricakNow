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

        String text = intent.getStringExtra(QuestionActivity.EXTRA_TEXT);

        TextView textView2 = findViewById(R.id.result);

        textView2.setText(text);
    }
}
