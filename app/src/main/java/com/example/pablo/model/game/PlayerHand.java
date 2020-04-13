package com.example.pablo.model.game;

import com.example.pablo.model.cards.Card;

import java.util.ArrayList;

public class PlayerHand {

    private ArrayList<Card> cards;

    public PlayerHand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
