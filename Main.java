package com.connect4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Üdvözöljük a Connect4 játékban!");

        String player1Name = "Játékos1";
        String player2Name = "Gép";

        Connect4Game game = new Connect4Game(player1Name, player2Name);
        game.start();
    }
}
