package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class Straight extends PokerHand {

    // represents the highest card of the straight
    private Card card;

    public Straight(Card card) {
        super(Hands.STRAIGHT);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        Straight handToCheck = (Straight) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return "Till " + String.valueOf(card.getValue());
    }
}
