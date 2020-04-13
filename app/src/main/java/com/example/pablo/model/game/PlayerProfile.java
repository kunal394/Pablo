package com.example.pablo.model.game;

public class PlayerProfile {

    private int id;

    private String name;

    public PlayerProfile(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
