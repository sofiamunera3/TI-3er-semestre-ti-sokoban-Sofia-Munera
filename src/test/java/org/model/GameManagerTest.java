package org.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameManagerTest {

    @Test
    void startGameTest_debeInicializarTableroAvatarYProgreso() {
        GameManager gameManager = new GameManager();

        gameManager.startGame();

        assertNotNull(gameManager.getBoard());
        assertNotNull(gameManager.getAvatar());
        assertNotNull(gameManager.getProgress());
    }

    @Test
    void loadLevelTest_debeCargarTableroDelNivelSeleccionado() {
        GameManager gameManager = new GameManager();
        Level level = new Level();
        Board board = new Board(6, 6);
        level.setBoard(board);

        gameManager.loadLevel(level);

        assertSame(board, gameManager.getBoard());
    }

    @Test
    void checkWinTest_debeRetornarTrueCuandoTodasLasCajasEstanEnObjetivos() {
        GameManager gameManager = new GameManager();
        gameManager.setBoard(new BoardStub(true));

        assertTrue(gameManager.checkWin());
    }

    @Test
    void checkWinTest_debeRetornarFalseCuandoFaltanCajasPorUbicar() {
        GameManager gameManager = new GameManager();
        gameManager.setBoard(new BoardStub(false));

        assertFalse(gameManager.checkWin());
    }

    private static class BoardStub extends Board {
        private final boolean allBoxesOnTargets;

        BoardStub(boolean allBoxesOnTargets) {
            super(1, 1);
            this.allBoxesOnTargets = allBoxesOnTargets;
        }

        @Override
        public boolean allBoxesOnTargets() {
            return allBoxesOnTargets;
        }
    }
}
