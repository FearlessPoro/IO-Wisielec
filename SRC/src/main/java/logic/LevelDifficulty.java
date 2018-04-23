package logic;

public enum LevelDifficulty {
    EASY(10), MEDIUM(20), HARD(30);

    private int points;

    LevelDifficulty(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
