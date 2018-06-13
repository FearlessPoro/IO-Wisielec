package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game testGame;

    @Before
    public void setUp() throws Exception {
        testGame = new Game(LevelDifficulty.EASY, Category.ALL, GameTypes.NEW_GAME, false);
    }

    @Test
    public void checkIfInGameTest() {
        testGame.start();
        Assert.assertTrue(testGame.checkIfInGame());
    }




}
