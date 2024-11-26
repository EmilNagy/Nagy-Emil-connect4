package com.connect4;

public class GameBoard {
    private final char[][] board;
    private static final int ROWS = 6;
    private static final int COLS = 7;

    public GameBoard() {
        board = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean dropPiece(int col, char color) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == ' ') {
                board[row][col] = color;
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("----------------------------");
    }

    public boolean checkWin(char color) {
        return checkHorizontal(color) || checkVertical(color) || checkDiagonal(color);
    }

    private boolean checkHorizontal(char color) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == color && board[row][col + 1] == color && board[row][col + 2] == color && board[row][col + 3] == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char color) {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[row][col] == color && board[row + 1][col] == color && board[row + 2][col] == color && board[row + 3][col] == color) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(char color) {
        // Főátló
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == color && board[row + 1][col + 1] == color && board[row + 2][col + 2] == color && board[row + 3][col + 3] == color) {
                    return true;
                }
            }
        }
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == color && board[row - 1][col + 1] == color && board[row - 2][col + 2] == color && board[row - 3][col + 3] == color) {
                    return true;
                }
            }
        }
        return false;
    }
}
