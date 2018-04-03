package entity;

public class HangManEntity {

    private int hearths;

    public HangManEntity() {
        this.hearths = 10;
    }

    public int getHearths() {
        return hearths;
    }

    public void decrementLives() {
        this.hearths--;
    }

    public boolean isAlive() {
        return hearths > 0;
    }
}
