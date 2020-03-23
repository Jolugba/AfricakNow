
package com.tinuade.africaknow.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quizies {

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
