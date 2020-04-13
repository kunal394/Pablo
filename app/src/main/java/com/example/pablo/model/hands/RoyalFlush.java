package com.example.pablo.model.hands;

import androidx.annotation.NonNull;

public class RoyalFlush extends PokerHand {

    public RoyalFlush() {
        super(Hands.ROYAL_FLUSH);
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        return true;
    }

    @NonNull
    @Override
    public String getString() {
        return "";
    }
}
