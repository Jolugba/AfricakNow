package com.tinuade.africaknow.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {
    @Query("SELECT * From  `question name`")
    LiveData<List<Questions>> getAllQuestions();

    @Insert
    void insert(Questions question);

    @Query("DELETE FROM `question name`")
    void deleteAll();
}
