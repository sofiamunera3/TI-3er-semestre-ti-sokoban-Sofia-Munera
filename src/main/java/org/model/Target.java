package org.model;

public class Target extends Piece {
    public Target(Coordinates location) {
        super(location);
    }

    public boolean isOccupied() {
        return false;
    }
}
