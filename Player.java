package com.connect4;

public class Player {
    private final String name;
    private final char color;

    public Player(String name, char color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }
}
