package entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RankEntity implements Serializable {

    static class Record implements Serializable {
        Integer points;
        String wordToGuess;

        Record(Integer points, String wordToGuess) {
            this.points = points;
            this.wordToGuess = wordToGuess;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Record)) return false;
            Record record = (Record) o;
            return Objects.equals(points, record.points) &&
                    Objects.equals(wordToGuess, record.wordToGuess);
        }

        @Override
        public int hashCode() {

            return Objects.hash(points, wordToGuess);
        }
    }

    private List<Record> rank =
            new ArrayList<>(5);

    public void addToRank(Integer points, String wordToGuess) {
        rank.add(new Record(points, wordToGuess));

        rank = rank.stream()
                .distinct()
                .sorted(Comparator.comparing(a -> (-a.points)))
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void serialize(RankEntity rank) {
        try (FileOutputStream fileOut = new FileOutputStream("src/main/resources/rank.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(rank);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static RankEntity deserialize() {
        RankEntity rank = new RankEntity();

        File f = new File("src/main/resources/rank.ser");

        if (f.exists() && !f.isDirectory()) {
            try (FileInputStream fileIn = new FileInputStream("src/main/resources/rank.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                rank = (RankEntity) in.readObject();
                clearSaves();
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }

        return rank;
    }

    private static void clearSaves() {
        File f = new File("src/main/resources/rank.ser");
        if (f.exists() && !f.isDirectory()) {
            if (f.delete()) {
                System.out.println("Usunieto save");
            }
        }
    }
}
