package com.connect4;

import java.util.Scanner;

public class Connect4Game {
    private final GameBoard gameBoard;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Connect4Game(String player1Name, String player2Name) {
        gameBoard = new GameBoard();
        player1 = new Player(player1Name, 'Y');
        player2 = new Player(player2Name, 'R');
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gameBoard.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getColor() + ") következik.");

            int col;
            if (currentPlayer.getColor() == 'Y') {
                System.out.print("Add meg az oszlop számát (0-6): ");
                col = scanner.nextInt();
            } else {
                col = (int)(Math.random() * 7);
            }

            if (col < 0 || col >= 7 || !gameBoard.dropPiece(col, currentPlayer.getColor())) {
                System.out.println("Hibás lépés! Próbáld újra.");
                continue;
            }

            if (gameBoard.checkWin(currentPlayer.getColor())) {
                gameBoard.printBoard();
                System.out.println(currentPlayer.getName() + " nyert!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }
}
