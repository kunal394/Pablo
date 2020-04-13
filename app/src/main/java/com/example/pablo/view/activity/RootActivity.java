package com.example.pablo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pablo.R;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        Button createGameButton = findViewById(R.id.create_btn);
        createGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWaitingLobby();
            }
        });

        Button joinGameButton = findViewById(R.id.join_btn);
        joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWaitingLobby();
            }
        });
    }

    private void launchWaitingLobby() {
        startActivity(new Intent(getApplicationContext(), WaitingLobbyActivity.class));
    }
}
