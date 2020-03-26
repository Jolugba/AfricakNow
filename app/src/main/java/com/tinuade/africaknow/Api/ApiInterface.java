package com.tinuade.africaknow.Api;

import com.tinuade.africaknow.Model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("quizes")
    Call<BaseResponse> getALLQuestions();
}
