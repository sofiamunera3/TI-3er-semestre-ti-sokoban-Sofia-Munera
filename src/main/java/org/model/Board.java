package org.model;

public class Board {

    private int broad;
    private int height;
    private Piece[][] cells;

    public Board(int broad, int height) {
    }

    public Piece getPiece(int x, int y) {
        return null;
    }

    public void setPiece(int x, int y, Piece piece) {
    }

    public boolean isFree(int x, int y) {
        return false;
    }

    public boolean allBoxesOnTargets() {
        return false;
    }

    public int getBroad() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public Piece[][] getCells() {
        return null;
    }
}
