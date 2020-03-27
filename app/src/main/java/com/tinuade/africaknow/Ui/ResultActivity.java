package com.tinuade.africaknow.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tinuade.africaknow.Model.HighScore;
import com.tinuade.africaknow.Model.User;
import com.tinuade.africaknow.R;

import static com.tinuade.africaknow.Ui.PlayGame.CURRENT_HIGH_SCORE;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int score = intent.getIntExtra(QuestionActivity.EXTRA_TEXT, 0);
        int currentHighScore = intent.getIntExtra(CURRENT_HIGH_SCORE, 0);
        Log.d("CurrentHighScore", currentHighScore + "");
        TextView textView2 = findViewById(R.id.result);
        textView2.setText("YOUR DEMO SCORE IS: " + score);

        DatabaseReference nameRef = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("high_scores").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        nameRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);
                HighScore userScore = new HighScore(score, currentUser.getFullName());
                if (currentHighScore < score) {
                    ref.setValue(userScore);
                } else {
                    ref.setValue(new HighScore(currentHighScore, currentUser.getFullName()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("ResultActivity", databaseError.getDetails());
            }
        });
    }
}
