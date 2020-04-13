package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class FourOfAKind extends PokerHand {

    private Card card;

    public FourOfAKind(Card card) {
        super(Hands.FOUR_OF_A_KIND);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        FourOfAKind handToCheck = (FourOfAKind) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return String.valueOf(card.getValue());
    }
}
