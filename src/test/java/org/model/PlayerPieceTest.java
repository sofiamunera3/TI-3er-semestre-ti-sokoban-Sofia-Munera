package org.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerPieceTest {

    @Test
    void moveTest_debeMoverArribaUnaCelda() {
        PlayerPiece playerPiece = new PlayerPiece(new Coordinates(4, 4));

        playerPiece.move(MoveDirection.UP);

        assertEquals(4, playerPiece.getLocation().getX());
        assertEquals(3, playerPiece.getLocation().getY());
    }

    @Test
    void moveTest_debeMoverAbajoUnaCelda() {
        PlayerPiece playerPiece = new PlayerPiece(new Coordinates(4, 4));

        playerPiece.move(MoveDirection.DOWN);

        assertEquals(4, playerPiece.getLocation().getX());
        assertEquals(5, playerPiece.getLocation().getY());
    }

    @Test
    void moveTest_debeMoverIzquierdaUnaCelda() {
        PlayerPiece playerPiece = new PlayerPiece(new Coordinates(4, 4));

        playerPiece.move(MoveDirection.LEFT);

        assertEquals(3, playerPiece.getLocation().getX());
        assertEquals(4, playerPiece.getLocation().getY());
    }

    @Test
    void moveTest_debeMoverDerechaUnaCelda() {
        PlayerPiece playerPiece = new PlayerPiece(new Coordinates(4, 4));

        playerPiece.move(MoveDirection.RIGHT);

        assertEquals(5, playerPiece.getLocation().getX());
        assertEquals(4, playerPiece.getLocation().getY());
    }
}
