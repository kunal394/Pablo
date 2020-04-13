package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class StraightFlush extends PokerHand {

    private Card card;

    public StraightFlush(Card card) {
        super(Hands.STRAIGHT_FLUSH);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        StraightFlush handToCheck = (StraightFlush) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return card.getSuite().getName() + ", till " + String.valueOf(card.getValue());
    }
}
