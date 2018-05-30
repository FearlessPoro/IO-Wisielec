package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class RankEntityTest {

    private RankEntity testEntity;
    private String testWord = "test";
    private Integer testPoints = 10;
    private RankEntity.Record testRecord = new RankEntity.Record(testPoints, testWord);

    @Before
    public void setUp() {
        testEntity = new RankEntity();
    }

    @Test
    public void addToRankTest() {
        testEntity.addToRank(testPoints, testWord);
        Assert.assertEquals(testEntity.getScoreAtSpecificIndex(0), testRecord);
    }

    @Test
    public void serializeTest() {
        RankEntity.serialize(testEntity);
        File file = new File(RankEntity.class.getResource("/rank.ser").getFile());
        Assert.assertTrue(file.exists());
    }

    @Test
    public void deserializeTest() {
        Assert.assertEquals(testEntity, RankEntity.deserialize());
    }

}
