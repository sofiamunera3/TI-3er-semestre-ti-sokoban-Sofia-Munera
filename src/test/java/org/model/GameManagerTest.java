package org.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameManagerTest {

    @Test
    void startGameTest() {
        GameManager gameManager = new GameManager();

        gameManager.startGame();

        assertNotNull(gameManager.getBoard());
        assertNotNull(gameManager.getAvatar());
        assertNotNull(gameManager.getProgress());
    }

    @Test
    void loadLevelTest() {
        GameManager gameManager = new GameManager();
        Level level = new Level();
        Board board = new Board(6, 6);
        level.setBoard(board);

        gameManager.loadLevel(level);

        assertSame(board, gameManager.getBoard());
    }

    @Test
    void checkWinTest_Valid() {
        GameManager gameManager = new GameManager();
        gameManager.setBoard(new Board(1, 1) {
            @Override
            public boolean allBoxesOnTargets() {
                return true;
            }
        });

        assertTrue(gameManager.checkWin());
    }

    @Test
    void checkWinTest_Invalid() {
        GameManager gameManager = new GameManager();
        gameManager.setBoard(new Board(1, 1) {
            @Override
            public boolean allBoxesOnTargets() {
                return false;
            }
        });

        assertFalse(gameManager.checkWin());
    }
}



