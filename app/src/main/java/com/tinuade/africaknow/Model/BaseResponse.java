package com.tinuade.africaknow.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("questions")
    private List<Question> mQuestions;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }

    public void setQuestions(List<Question> questions) {
        mQuestions = questions;
    }

}
