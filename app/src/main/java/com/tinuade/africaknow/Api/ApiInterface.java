package com.tinuade.africaknow.Api;


import com.tinuade.africaknow.Model.QuestionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("quizes")
    Call<List<QuestionModel>> getALLQuestions();
}
