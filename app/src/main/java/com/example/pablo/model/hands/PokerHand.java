package com.example.pablo.model.hands;

import androidx.annotation.NonNull;

public abstract class PokerHand {

    // straight or high card, etc.
    protected Hands hand;

    public PokerHand(Hands hand) {
        this.hand = hand;
    }

    public int getHandId() {
        return hand.getId();
    }

    public String getName() {
        return hand.getName();
    }

    @NonNull
    @Override
    public String toString() {
        return getName() + " : " + getString();
    }

    public abstract boolean isHigherThan(PokerHand pokerHand);

    @NonNull
    public abstract String getString();
}
