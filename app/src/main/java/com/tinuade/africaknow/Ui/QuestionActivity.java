package com.tinuade.africaknow.Ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tinuade.africaknow.Database.Questions;
import com.tinuade.africaknow.R;
import com.tinuade.africaknow.ViewModel.QuestionViewModel;

import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    List<Questions> quesList;
    int score=0;
    int qid=0;
    Questions currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;
    private QuestionViewModel questionsViewModel;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }
}
