package com.example.pablo.model.hands;

import com.example.pablo.model.cards.Card;

import androidx.annotation.NonNull;

public class TwoPair extends PokerHand {

    // always store in this format.
    private Card highCard;

    private Card lowCard;

    public TwoPair(Card high, Card low) {
        super(Hands.ONE_PAIR);
        if (high.getValue() == low.getValue()) {
            throw new UnsupportedOperationException("Same two pairs are not allowed!");
        } else if (high.getValue() > low.getValue()) {
            this.highCard = high;
            this.lowCard = low;
        } else {
            this.highCard = low;
            this.lowCard = high;
        }
    }

    public Card getHighCard() {
        return highCard;
    }

    public Card getLowCard() {
        return lowCard;
    }

    @Override
    public boolean isHigherThan(PokerHand pokerHand) {
        TwoPair handToCheck = (TwoPair) pokerHand;
        if (getHighCard().getValue() > handToCheck.getHighCard().getValue()) {
            return true;
        } else if (getHighCard().getValue() == handToCheck.getHighCard().getValue()) {
            return getLowCard().getValue() > handToCheck.getLowCard().getValue();
        } else {
            return false;
        }
    }

    @NonNull
    @Override
    public String getString() {
        return String.valueOf(lowCard.getValue()) + ", " + String.valueOf(highCard.getValue());
    }
}
