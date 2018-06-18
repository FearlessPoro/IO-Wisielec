package dao;

import entity.WordEntity;
import logic.Category;
import logic.LevelDifficulty;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
        setFileName(fileName);
    }

    public CsvDao(String fileName, Category category) {
        setFileName(fileName);
        setCategory(category);
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

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private Reader source;
    private Category category;
    private LevelDifficulty level;
    private String fileName;


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

    private void addPassword(String passwordToAdd) throws URISyntaxException, FileNotFoundException {
        System.out.println("probuje");

        int passwordLength = passwordToAdd.length();
        if (passwordLength >= 2 && passwordLength <= 8) {
            level = LevelDifficulty.EASY;
        } else {
            if (passwordLength >= 9 && passwordLength <= 14 ){
                level = LevelDifficulty.MEDIUM;
            } else {
                level = LevelDifficulty.HARD;
            }
        }

        String record = "\n" + category.name() + SEPARATOR + level.name() + SEPARATOR + passwordToAdd;
        URL resourceUrl = getClass().getResource("/database/" + fileName);
        File file = new File(resourceUrl.toURI());
        OutputStream output = new FileOutputStream(file, true);
        try {
            output.write(record.getBytes());
            output.flush();
            output.close();
        }catch (IOException e) {
            System.out.println("nie udalo sie");
            System.out.println(e);
        }
    }

    public String canAdd(String passwordToAdd, String passwordToConfirm) throws FileNotFoundException, URISyntaxException {
        String newPasswordToAdd = passwordToAdd.trim().toUpperCase();
        String newPasswordToConfirm = passwordToConfirm.trim().toUpperCase();
        if (!newPasswordToAdd.equals(newPasswordToConfirm)){
            return "Hasła nie zgadzają się";
        } else {
            if (newPasswordToAdd.length() > 30 || newPasswordToConfirm.length() < 2){
                return "Nieprawidłowa długość hasła";
            } else {
                if (!newPasswordToAdd.matches("[a-zA-Z\\s]*")){
                    return "Hasło musi składać się z liter";
                } else {
                    addPassword(newPasswordToAdd);
                    return "Hasło dodane do bazy";
                }
            }
        }
    }


}
