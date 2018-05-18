package dao;

import org.junit.Before;

public class CsvDaoTest {

    private CsvDao testDao;

    @Before
    public void setUp() {
        testDao = new CsvDao("sample.csv");
    }
}