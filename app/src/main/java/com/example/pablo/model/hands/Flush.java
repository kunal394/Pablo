package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class Flush extends PokerHand {

    // represents the highest card of the flush
    private Card card;

    public Flush(Card card) {
        super(Hands.FLUSH);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        Flush handToCheck = (Flush) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return getCard().getSuite().getName() + " : " + String.valueOf(card.getValue());
    }
}
