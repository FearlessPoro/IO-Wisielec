package dao;

import entity.WordEntity;
import logic.Category;
import logic.LevelDifficulty;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class CsvDao {
    private static final String SEPARATOR = ";";

    public CsvDao(String fileName, Category category, LevelDifficulty level) {
        setSourcePath(fileName);
        setCategory(category);
        setLevelDifficulty(level);
    }

    private void setSourcePath(String fileName) {
        this.source = new BufferedReader(
                        new InputStreamReader(this.getClass().getResourceAsStream("/database/" + fileName)));
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    private void setLevelDifficulty(LevelDifficulty level) {
        this.level = level;
    }

    private Reader source;
    private Category category;
    private LevelDifficulty level;


    List<List<String>> readRecords() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    public WordEntity getRandomWord() {
        List<List<String>> allWords = readRecords();

        Iterator<List<String>> iterator = allWords.iterator();
        while (iterator.hasNext()) {
            List<String> item = iterator.next();

            if ((!item.get(1).equals(level.name())) ||
                    (!category.name().equals("ALL")) && !item.get(0).equals(category.name()))
                iterator.remove();
        }

        Random random = new Random();
        int randomPasswordIndex = random.nextInt(allWords.size());
        List<String> categoryToGuess = allWords.get(randomPasswordIndex);

        return new WordEntity(categoryToGuess.get(2));
    }



}
