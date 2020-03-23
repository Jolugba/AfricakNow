package com.tinuade.africaknow.Api;


import com.tinuade.africaknow.Model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("all")
    Call<List<Question>> getALLCountries();
}
