package com.tinuade.africaknow.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="question name")
public class Questions {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="id")
    private int id;

    @NonNull
    @ColumnInfo(name ="question")
    private String question;

    @NonNull
    @ColumnInfo(name ="answer")
    private String answer;

    @NonNull
    @ColumnInfo(name ="optA")
    private String optA;

    @NonNull
    @ColumnInfo(name ="optB")
    private String optB;

    @NonNull
    @ColumnInfo(name ="optC")
    private String optC;

    @NonNull
    @ColumnInfo(name ="optD")
    private String optD;

    public Questions(int id, @NonNull String question, @NonNull String answer, @NonNull String optA, @NonNull String optB, @NonNull String optC, @NonNull String optD) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
    }
    public Questions(){
        id = 0;
        question ="";
        answer = "";
        optA = "";
        optB = "";
        optC = "";
        optD = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    @NonNull
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(@NonNull String answer) {
        this.answer = answer;
    }

    @NonNull
    public String getOptA() {
        return optA;
    }

    public void setOptA(@NonNull String optA) {
        this.optA = optA;
    }

    @NonNull
    public String getOptB() {
        return optB;
    }

    public void setOptB(@NonNull String optB) {
        this.optB = optB;
    }

    @NonNull
    public String getOptC() {
        return optC;
    }

    public void setOptC(@NonNull String optC) {
        this.optC = optC;
    }

    @NonNull
    public String getOptD() {
        return optD;
    }

    public void setOptD(@NonNull String optD) {
        this.optD = optD;
    }
}
