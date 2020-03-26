package com.tinuade.africaknow.Ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.tinuade.africaknow.Api.ApiInterface;
import com.tinuade.africaknow.Api.RetrofitClient;
import com.tinuade.africaknow.QuizAdapter;
import com.tinuade.africaknow.R;
import com.tinuade.africaknow.ViewModel.QuestionViewModel;
import com.tinuade.africaknow.Model.BaseResponse;

public class QuestionActivity extends AppCompatActivity {

    private QuestionViewModel mViewModel;
    private TextView mTotalQuestionsTextView, mCurrentQuestionTextView;
    private ViewPager2 mPager2;
    private Button mNextButton;
    private int numberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        mTotalQuestionsTextView = findViewById(R.id.total_questions_textView);
        mCurrentQuestionTextView = findViewById(R.id.current_question_textView);
        mPager2 = findViewById(R.id.view_pager);
        mNextButton = findViewById(R.id.confirm_button);

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

        mViewModel.getQuiz().observe(this, baseResponse -> {
            mTotalQuestionsTextView.setText(String.valueOf(baseResponse.getQuestions().size()));
            numberOfQuestions = baseResponse.getQuestions().size();
            QuizAdapter adapter = new QuizAdapter(baseResponse.getQuestions());
            mPager2.setAdapter(adapter);
            mNextButton.setOnClickListener(v -> {
                if (mPager2.getCurrentItem() < baseResponse.getQuestions().size() - 1) {
                    mPager2.setCurrentItem(mPager2.getCurrentItem() + 1);
                } else {
                    // Quiz has ended, user has submitted
                    //TODO: Take the user to the result page nd display user score
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
                if (position == numberOfQuestions -1) {
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
