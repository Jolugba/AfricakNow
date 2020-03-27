package com.tinuade.africaknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import com.tinuade.africaknow.Ui.Sign_In;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Enable offline persistence
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        Intent intent = new Intent(this, Sign_In.class);
        startActivity(intent);
        finish();
    }
}
