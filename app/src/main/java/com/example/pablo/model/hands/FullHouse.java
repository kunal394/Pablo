package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class FullHouse extends PokerHand {

    // always store in this format.
    private Card tripleCard;

    private Card doubleCard;

    public FullHouse(Card tripleCard, Card doubleCard) {
        super(Hands.FULL_HOUSE);
        if (tripleCard.getValue() == doubleCard.getValue()) {
            throw new UnsupportedOperationException("Both cards cannot be same!");
        }
        this.tripleCard = tripleCard;
        this.doubleCard = doubleCard;
    }

    public Card getTripleCard() {
        return tripleCard;
    }

    public Card getDoubleCard() {
        return doubleCard;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        FullHouse handToCheck = (FullHouse) pokerHand;
        if (getTripleCard().getValue() > handToCheck.getTripleCard().getValue()) {
            return true;
        } else if (getTripleCard().getValue() == handToCheck.getTripleCard().getValue()) {
            return getDoubleCard().getValue() > handToCheck.getDoubleCard().getValue();
        } else {
            return false;
        }
    }

    @NonNull
    @Override
    public String getString() {
        return "3 of " + tripleCard.getValue() + ", 2 of " + doubleCard.getValue();
    }
}
