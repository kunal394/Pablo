package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class HighCard extends PokerHand {

    private Card card;

    public HighCard(Card card) {
        super(Hands.HIGH_CARD);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        HighCard handToCheck = (HighCard) pokerHand;
        return card.getValue() > handToCheck.getCard().getValue();
    }

    @NonNull
    @Override
    public String getString() {
        return String.valueOf(card.getValue());
    }
}
