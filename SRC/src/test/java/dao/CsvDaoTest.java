package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CsvDaoTest {

    private CsvDao testDao;

    @Before
    public void setUp() {
        testDao = new CsvDao("sample.csv");
    }

    @Test
    public void readsRecords() {
        List<List<String>> records = testDao.readRecords();

        Assert.assertEquals(2, records.size());
        Assert.assertTrue(records.contains(Arrays.asList("word1", "word2")));
        Assert.assertTrue(records.contains(Arrays.asList("word3", "word4")));
    }
}