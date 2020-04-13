package com.example.pablo.view.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pablo.R;
import com.example.pablo.model.cards.Card;
import com.example.pablo.model.cards.CardsFactory;
import com.example.pablo.model.game.PlayerHand;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class PlayerHandView extends LinearLayout {

    private static final String TAG = PlayerHandView.class.getSimpleName();

    private ArrayList<ImageView> cardViews = new ArrayList<>();


    public PlayerHandView(Context context) {
        super(context);
        init(context);
    }

    public PlayerHandView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayerHandView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setPlayerHand(PlayerHand hand) {
        ArrayList<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            int cardIconResId = CardsFactory.getInstance().getCardIconResId(cards.get(i).getId());
            ImageView imageView = cardViews.get(i);
            imageView.setImageDrawable(getResources().getDrawable(cardIconResId, null));
            imageView.setVisibility(View.VISIBLE);
        }
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.player_hand_layout, this, true);
        initCards();
    }

    private void initCards() {
        ImageView card1 = findViewById(R.id.card1);
        ImageView card2 = findViewById(R.id.card2);
        ImageView card3 = findViewById(R.id.card3);
        ImageView card4 = findViewById(R.id.card4);
        ImageView card5 = findViewById(R.id.card5);
        ImageView card6 = findViewById(R.id.card6);
        ImageView card7 = findViewById(R.id.card7);
        card1.setVisibility(View.GONE);
        card2.setVisibility(View.GONE);
        card3.setVisibility(View.GONE);
        card4.setVisibility(View.GONE);
        card5.setVisibility(View.GONE);
        card6.setVisibility(View.GONE);
        card7.setVisibility(View.GONE);
        cardViews.add(card1);
        cardViews.add(card2);
        cardViews.add(card3);
        cardViews.add(card4);
        cardViews.add(card5);
        cardViews.add(card6);
        cardViews.add(card7);
    }
}
