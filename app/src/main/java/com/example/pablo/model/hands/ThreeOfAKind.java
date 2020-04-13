package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class ThreeOfAKind extends PokerHand {

    private Card card;

    public ThreeOfAKind(Card card) {
        super(Hands.THREE_OF_A_KIND);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        ThreeOfAKind handToCheck = (ThreeOfAKind) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return String.valueOf(card.getValue());
    }
}
