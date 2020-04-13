package com.example.pablo.view.activity;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pablo.R;
import com.example.pablo.model.game.GameState;
import com.example.pablo.model.game.Player;
import com.example.pablo.view.helper.PlayerDetailView;
import com.example.pablo.view.helper.PlayerHandView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class GameRoomActivity extends AppCompatActivity {

    // player id vs player detail
    private SparseArray<PlayerDetailView> playerDetailViewsMap = new SparseArray<>();
    private PlayerHandView playerHandView;
    private Button showBtn;
    private TextView lastPokerHandView;
    private ArrayList<Integer> playerIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_room);
        initViews();
        startGame();
    }

    private void initViews() {
        playerIds = new ArrayList<>(GameState.getInstance().getPlayerIds());
        playerHandView = findViewById(R.id.player_hand_layout);
        PlayerDetailView playerDetailView1 = findViewById(R.id.player1_area_layout);
        PlayerDetailView playerDetailView2 = findViewById(R.id.player2_area_layout);
        ArrayList<PlayerDetailView> playerDetailViews = new ArrayList<>();
        playerDetailViews.add(playerDetailView1);
        playerDetailViews.add(playerDetailView2);
        int i;
        for (i = 0; i < playerIds.size(); i++) {
            PlayerDetailView playerDetailView = playerDetailViews.get(i);
            Integer id = playerIds.get(i);
            playerDetailViewsMap.put(id, playerDetailView);
            Player player = GameState.getInstance().getPlayer(id);
            playerDetailView.setPlayerDetails(player.getProfile(),
                    GameState.getInstance().getPlayerCardCount(id));
        }

        // hide player detail layouts which are not being used
        for (int j = i; j < playerDetailViews.size(); j++) {
            playerDetailViews.get(j).setVisibility(View.GONE);
        }

        showBtn = findViewById(R.id.show_button);
        lastPokerHandView = findViewById(R.id.last_poker_hand_tv);
        lastPokerHandView.setText("");
        showBtn.setEnabled(false);
    }

    private void startGame() {
        GameState.getInstance().startGame();
        // TODO: 13-04-2020 not required in multiplayer. In multiplayer set only at the start of the round
        setHandsView(GameState.getInstance().getCurrentMovePlayerId());
    }

    private void setHandsView(int playerId) {
        playerHandView.setPlayerHand(GameState.getInstance().getRandomCardIds(playerId));
    }
}
