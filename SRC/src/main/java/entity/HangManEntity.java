package entity;

import java.io.Serializable;

public class HangManEntity implements Serializable {

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

    public void setLivesToZero() { this.hearths = 0; }

    public boolean isAlive() {
        return hearths > 0;
    }
}
