package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class OnePair extends PokerHand {

    private Card card;

    public OnePair(Card card) {
        super(Hands.ONE_PAIR);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        OnePair handToCheck = (OnePair) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return String.valueOf(card.getValue());
    }
}
