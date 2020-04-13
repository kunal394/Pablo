package com.example.pablo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pablo.R;
import com.example.pablo.model.game.GameState;
import com.example.pablo.model.game.Player;
import com.example.pablo.model.game.PlayerProfile;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class WaitingLobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_lobby);
        setTitle("Waiting Lobby");
        Button startGameBtn = findViewById(R.id.start_game_btn);
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchGameRoom();
            }
        });
    }

    private void launchGameRoom() {
        ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player(new PlayerProfile(1, "Player1"));
        Player p2 = new Player(new PlayerProfile(2, "Player2"));
        players.add(p1);
        players.add(p2);
        GameState.getInstance().init(players, 1, 1);
        startActivity(new Intent(getApplicationContext(), GameRoomActivity.class));
    }
}
