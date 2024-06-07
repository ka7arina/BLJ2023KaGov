package ch.noseryoung;

import java.awt.*;

public class Game {
    private int[][] gameField;
    private int[][] initialGameField;
    private Point initialPlayerLoc;
    private Point playerLoc;

    /**
     * Initializes the game with the initial game field and player location.
     * Makes a deep copy of the initial game field.
     */
    public Game() {
        this(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 4, 0, 3, 2, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 3, 4, 1, 0, 0},
                {0, 1, 4, 1, 1, 3, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 4, 0, 1, 1, 0},
                {0, 1, 3, 0, 3, 0, 3, 4, 1, 0},
                {0, 1, 0, 0, 0, 4, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        });
    }

    /**
     * Initializes the game with a custom game field.
     *
     * @param gameField The custom game field.
     */
    public Game(int[][] gameField) {
        this.gameField = gameField;

        // Make a deep copy of the initial game field
        initialGameField = new int[gameField.length][];
        for (int i = 0; i < gameField.length; i++) {
            initialGameField[i] = gameField[i].clone();
        }

        // Find the player's initial location and store it
        for (int x = 0; x < getColCount(); x++) {
            for (int y = 0; y < getRowCount(); y++) {
                if (gameField[x][y] == 2) {
                    playerLoc = new Point(x, y);
                    initialPlayerLoc = new Point(x, y);
                    System.out.println(playerLoc);
                    return;
                }
            }
        }
    }



    private void hasWon() {
        for (int i = 0; i < getColCount(); i++) {
            for (int j = 0; j < getRowCount(); j++) {
                if (gameField[i][j] == 4) {
                    return;
                }
            }
        }
        System.out.println("HEY IM GONNA DO IT MY WAY Τα, τα, τα, τα-τα !!!!!! \uD83C\uDDEC\uD83C\uDDF7 \uD83C\uDDEC\uD83C\uDDF7 ZARI https://youtu.be/mTSTnLWGUPs?si=aG3cRYeLxZCmIC9E ");
    }


    /**
     * ÜBERPRÜFT WO ES BARRIER HAT UND MACHT DAS MAN NICHT DURCH KANN
     */
    private boolean canMove(int x, int y) {
        return gameField[x][y] != 1; // check for barriers
    }

    /**
     * NICHT GLEICHZEITIG DEN SPIELER UND BOX BEWEGEN. NACHRUTSCHEN BESSER! (von andrew)
     */

    /* move funktion: bewegt den spieler */
    private void move(int dx, int dy) {
        int newX = playerLoc.x + dx;
        int newY = playerLoc.y + dy;
        int nextX = newX + dx;
        int nextY = newY + dy;

        boolean movingFromDestination = gameField[playerLoc.x][playerLoc.y] == 4;
        boolean movingFromCompletedBox = gameField[playerLoc.x][playerLoc.y] == 5;

        if (canMove(newX, newY)) {
            /* Check if there is a box and if it can be moved */
            if ((gameField[newX][newY] == 3 || gameField[newX][newY] == 5) && (gameField[nextX][nextY] == 0 || gameField[nextX][nextY] == 4)) {
                moveBox(newX, newY, nextX, nextY); // Move the box first
            }

            /* Ensure the player can move to the new position */
            if (gameField[newX][newY] != 3 && gameField[newX][newY] != 5) {
                if (movingFromDestination) {
                    gameField[playerLoc.x][playerLoc.y] = 4; // Reset to destination if moving off it
                } else if (movingFromCompletedBox) {
                    gameField[playerLoc.x][playerLoc.y] = 4; // Reset to destination if moving off it
                } else {
                    gameField[playerLoc.x][playerLoc.y] = 0; // Clear current player position
                }

                playerLoc.translate(dx, dy); // Update player location

                if (gameField[playerLoc.x][playerLoc.y] != 4 && gameField[playerLoc.x][playerLoc.y] != 5) {
                    gameField[playerLoc.x][playerLoc.y] = 2; // Set new player position
                }
            }

            hasWon();
        }
    }

    /** moveBox method: moves the box
     *
     * @param dx
     * @param dy
     * @param x
     * @param y
     */
    private void moveBox(int dx, int dy, int x, int y) {
        if (gameField[dx][dy] == 3 || gameField[dx][dy] == 5) {
            boolean movingFromDestination = gameField[dx][dy] == 5;

            gameField[dx][dy] = 0; // clear current box position
            if (movingFromDestination) {
                gameField[dx][dy] = 4; // if it was a completed box, reset to destination point
            }
            gameField[x][y] = gameField[x][y] == 4 ? 5 : 3; // set new position of box
        }
    }

    public void moveUp() {
        move(-1, 0);
    }

    public void moveDown() {
        move(1, 0);
    }

    public void moveLeft() {
        move(0, -1);
    }

    public void moveRight() {
        move(0, 1);
    }

    public void resetField() {
        // Reset the game field to the initial state
        for (int i = 0; i < gameField.length; i++) {
            gameField[i] = initialGameField[i].clone();
        }
        // Reset the player location to the initial position
        playerLoc.setLocation(initialPlayerLoc);
    }

    public int[][] getField() {
        return gameField;
    }

    public int getColCount() {
        return gameField.length;
    }

    public int getRowCount() {
        return gameField[0].length;
    }
}
