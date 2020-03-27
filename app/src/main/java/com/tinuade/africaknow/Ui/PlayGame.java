package com.tinuade.africaknow.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tinuade.africaknow.Model.HighScore;
import com.tinuade.africaknow.R;
import com.tinuade.africaknow.adapter.HighScoreAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayGame extends AppCompatActivity {

    static final String CURRENT_HIGH_SCORE = "com.tinuade.africaknow.Ui.CURRENT_HIGH_SCORE";
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("high_scores");
    int currentHighScore = 0;
    List<HighScore> mScoreList = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //widgets
        Button playGame = findViewById(R.id.playGame);
        playGame.setOnClickListener(v -> {
            Intent intent = new Intent(PlayGame.this, QuestionActivity.class);
            intent.putExtra(CURRENT_HIGH_SCORE, currentHighScore);
            Log.d("CurrentHighScoreIntent", currentHighScore + "");
            startActivity(intent);
        });

        // Setup recyclerView
        mRecyclerView = findViewById(R.id.high_score_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Getting current user's high score
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mRef.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HighScore object = dataSnapshot.getValue(HighScore.class);
                if (object != null) {
                    currentHighScore = object.getScore();
                    Log.d("CurrentHighScore", currentHighScore + "");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("PlayGame", databaseError.getMessage());
            }
        });

        // Getting all high score
        mRef.orderByChild("score").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mScoreList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    HighScore highScore = snapshot.getValue(HighScore.class);
                    mScoreList.add(highScore);
                }
                Collections.reverse(mScoreList);
                HighScoreAdapter adapter = new HighScoreAdapter(mScoreList);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("PlayGame", databaseError.getMessage());
            }
        });
    }
}
