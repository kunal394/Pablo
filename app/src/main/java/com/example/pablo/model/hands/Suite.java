package com.example.pablo.model.hands;

public enum Suite {

    SPADES(0, "Spades"),
    CLUBS(1, "Clubs"),
    HEARTS(2, "Hearts"),
    DIAMONDS(3, "Diamonds");

    private int id;
    private String name;

    Suite(int id, String name) {
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
