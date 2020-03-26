
package com.tinuade.africaknow.Model;

import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("option")
    private String mOption;
    @SerializedName("value")
    private Boolean mValue;

    public String getOption() {
        return mOption;
    }

    public void setOption(String option) {
        mOption = option;
    }

    public Boolean getValue() {
        return mValue;
    }

    public void setValue(Boolean value) {
        mValue = value;
    }

}
