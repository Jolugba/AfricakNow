package com.tinuade.africaknow.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.tinuade.africaknow.Api.ApiInterface;
import com.tinuade.africaknow.Api.RetrofitClient;
import com.tinuade.africaknow.Model.BaseResponse;
import com.tinuade.africaknow.QuizAdapter;
import com.tinuade.africaknow.R;
import com.tinuade.africaknow.ViewModel.QuestionViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "estherjolugba@yahoo.com.EXTRA_NUMBER";
    private QuestionViewModel mViewModel;
    private TextView mTotalQuestionsTextView, mCurrentQuestionTextView, mWrongTextView, mCorrectTextView;
    private ViewPager2 mPager2;
    private Button mNextButton;
    private int numberOfQuestions;
    private TextView mScore;

    private int score = 0;
    private int correct = 0;
    private int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        mTotalQuestionsTextView = findViewById(R.id.total_questions_textView);
        mCurrentQuestionTextView = findViewById(R.id.current_question_textView);
        mWrongTextView = findViewById(R.id.wrong_textView);
        mCorrectTextView = findViewById(R.id.correct_textView);
        mScore = findViewById(R.id.score_textView);
        mPager2 = findViewById(R.id.view_pager);
        mNextButton = findViewById(R.id.confirm_button);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loadingProgressBar.setVisibility(View.INVISIBLE);

        // Make API call
        ApiInterface api = RetrofitClient.getService();
        api.getALLQuestions().enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                mViewModel.setQuiz(response.body());
                Log.d("QuestionActivity", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d("QuestionActivity", t.getLocalizedMessage());
            }
        });
        loadingProgressBar.setVisibility(View.VISIBLE);
        mViewModel.getQuiz().observe(this, baseResponse -> {
            mTotalQuestionsTextView.setText(String.valueOf(baseResponse.getQuestions().size()));
            numberOfQuestions = baseResponse.getQuestions().size();
            QuizAdapter adapter = new QuizAdapter(baseResponse.getQuestions());
            mPager2.setAdapter(adapter);
            loadingProgressBar.setVisibility(View.GONE);
            mNextButton.setOnClickListener(v -> {
                if (QuizAdapter.isOptionSelected) {
                    if (QuizAdapter.answerValue) {
                        score += 10;
                        correct++;
                        Toast.makeText(QuestionActivity.this, "You are on fire Genius", Toast.LENGTH_SHORT).show();
                        String value = String.valueOf(score);
                        mScore.setText(value);
                        mCorrectTextView.setText(String.valueOf(correct));
                        if (mPager2.getCurrentItem() < baseResponse.getQuestions().size() - 1) {
                            mPager2.setCurrentItem(mPager2.getCurrentItem() + 1);
                        } else {
                            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                            intent.putExtra(EXTRA_TEXT, score);
                            startActivity(intent);
                            finish();
                            // Quiz has ended, user has submitted
                        }

                    } else {
                        // User selects a wrong answer
                        wrong ++;
                        String value = String.valueOf(wrong);
                        mWrongTextView.setText(value);
                        Toast.makeText(QuestionActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        if (mPager2.getCurrentItem() < baseResponse.getQuestions().size() - 1) {
                            mPager2.setCurrentItem(mPager2.getCurrentItem() + 1);
                        } else {
                            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                            intent.putExtra(EXTRA_TEXT, score);
                            startActivity(intent);
                            finish();
                        }
                    }
                } else {
                    Toast.makeText(QuestionActivity.this, "Please Select an answer", Toast.LENGTH_SHORT).show();
                }

            });
        });

        // Disables Swipe action
        mPager2.setUserInputEnabled(false);

        mPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == numberOfQuestions - 1) {
                    mNextButton.setText("Submit");
                } else {
                    mNextButton.setText("Next");
                }
                mCurrentQuestionTextView.setText(String.valueOf(position + 1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void enableButton(Button button) {
        button.setEnabled(true);
    }

    private void disableButton(Button button) {
        button.setEnabled(false);
    }
}
