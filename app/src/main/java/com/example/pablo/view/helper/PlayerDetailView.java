package com.example.pablo.view.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pablo.R;
import com.example.pablo.model.game.PlayerProfile;
import com.example.pablo.model.hands.PokerHand;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerDetailView extends LinearLayout {

    private static final String TAG = PlayerDetailView.class.getSimpleName();

    private ImageView profileImageView;
    private TextView cardsCountView, profileNameView;
    private RecyclerView lastCalledPokerHandsListView;
    private PlayerLastPokerHandsListAdapter mAdapter;
    private ArrayList<PokerHand> lastCalledPokerHands;

    public PlayerDetailView(Context context) {
        super(context);
        init(context);
    }

    public PlayerDetailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayerDetailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setPlayerDetails(PlayerProfile playerProfile, int count) {
        // TODO: 13-04-2020 set icon from profile after code with backend is complete
        profileImageView.setImageDrawable(getResources().getDrawable(R.drawable.default_user_profile_icon, null));
        cardsCountView.setText(String.valueOf(count));
        profileNameView.setText(playerProfile.getName());
    }

    public void updateLastCalledPokerHand(PokerHand pokerHand) {
        Log.d(TAG, "updateLastCalledPokerHand: pokerHand: " + pokerHand.toString());
        updateLastCalledPokerHandsLocally(pokerHand);
        if (mAdapter == null) {
            Log.d(TAG, "updateLastCalledPokerHand: adapter null!");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                    RecyclerView.VERTICAL, true);
            lastCalledPokerHandsListView.setLayoutManager(linearLayoutManager);
            mAdapter = new PlayerLastPokerHandsListAdapter(getContext(), lastCalledPokerHands);
            lastCalledPokerHandsListView.setAdapter(mAdapter);
        } else {
            Log.d(TAG, "updateLastCalledPokerHand: adapter not null!");
            mAdapter.updatePokerHands(lastCalledPokerHands);
        }
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.player_game_detail_common_layout, this, true);

        profileImageView = findViewById(R.id.profile_img);
        cardsCountView = findViewById(R.id.cards_count);
        profileNameView = findViewById(R.id.profile_name);
        lastCalledPokerHandsListView = findViewById(R.id.lastCalledPokerHandsList);
    }

    private void updateLastCalledPokerHandsLocally(PokerHand lastCalledPokerHand) {
        if (lastCalledPokerHands == null) {
            lastCalledPokerHands = new ArrayList<>();
        }
        lastCalledPokerHands.add(lastCalledPokerHand);
    }
}
