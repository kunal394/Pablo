package com.example.pablo.model.cards;

import com.example.pablo.model.hands.Suite;

public class Card {

    // id represents the card position in total 52 cards
    private int id;
    private Suite suite;
    private int value;

    public Card(int id, Suite suite, int value) {
        this.id = id;
        this.suite = suite;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Suite getSuite() {
        return suite;
    }

    public int getValue() {
        return value;
    }
}
