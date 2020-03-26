package com.tinuade.africaknow.ViewModel;

import com.tinuade.africaknow.Model.BaseResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuestionViewModel extends ViewModel {
    private MutableLiveData<BaseResponse> quiz = new MutableLiveData<>();
    private MutableLiveData<Integer> correctAnswer = new MutableLiveData<>();

    public LiveData<BaseResponse> getQuiz() {
        return quiz;
    }

    public void setQuiz(BaseResponse quiz) {
        this.quiz.postValue(quiz);
    }

    public MutableLiveData<Integer> getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer.postValue(correctAnswer);
    }
}
