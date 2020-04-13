package com.example.pablo.model.hands;

public enum Hands {

    HIGH_CARD(0, "HIGH_CARD"),
    ONE_PAIR(1, "ONE_PAIR"),
    TWO_PAIR(2, "TWO_PAIR"),
    THREE_OF_A_KIND(3, "THREE_OF_A_KIND"),
    STRAIGHT(4, "STRAIGHT"),
    FLUSH(5, "FLUSH"),
    FULL_HOUSE(6, "FULL_HOUSE"),
    FOUR_OF_A_KIND(7, "FOUR_OF_A_KIND"),
    STRAIGHT_FLUSH(8, "STRAIGHT_FLUSH"),
    ROYAL_FLUSH(9, "ROYAL_FLUSH");

    private int id;
    private String name;

    Hands(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
