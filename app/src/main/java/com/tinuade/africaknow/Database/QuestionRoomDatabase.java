package com.tinuade.africaknow.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Questions.class,version = 1)
public abstract class QuestionRoomDatabase extends RoomDatabase {

    public abstract QuestionDao wordDao();
    private static QuestionRoomDatabase INSTANCE;

    static QuestionRoomDatabase getDatabase(final Context context){
        if (INSTANCE==null){
            synchronized (QuestionRoomDatabase.class){
                if (INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            QuestionRoomDatabase.class,"questions")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
        }
    };

}
