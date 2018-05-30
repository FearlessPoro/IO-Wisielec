package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RankEntityTest {

    private RankEntity testEntity;
    private String testWord = "test";
    private Integer testPoints = 10;
    private RankEntity.Record testRecord = new RankEntity.Record(testPoints, testWord);

    @Test
    public void addToRankTest() {
        testEntity.addToRank(testPoints, testWord);
        Assert.assertEquals(testEntity.getScoreAtSpecificIndex(0), testRecord);
    }

}
