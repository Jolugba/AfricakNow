package com.tinuade.africaknow.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tinuade.africaknow.Database.QuestionRespository;
import com.tinuade.africaknow.Database.Questions;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRespository questionRespository;
    private LiveData<List<Questions>> mALLQuestions;

    public QuestionViewModel (Application application){
        super(application);
        questionRespository=new QuestionRespository(application);
        mALLQuestions=questionRespository.getmAllQuestions();
    }

    public LiveData<List<Questions>> getmALLQuestions() {
        return mALLQuestions;
    }
    protected void insert(Questions word){
        questionRespository.insert(word);
    }
}
