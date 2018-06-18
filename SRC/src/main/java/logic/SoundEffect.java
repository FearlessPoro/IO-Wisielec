package logic;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public enum SoundEffect {
    BAD_LETTER("sounds/wrong.wav"),
    GOOD_LETTER("sounds/good.wav"),
    GAME_LOST("sounds/lost.wav"),
    GAME_WON("sounds/won.wav");

    private Clip clip;

    SoundEffect(String soundFileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(url));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip.isRunning()) {
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }

    static public void init() {
        values();
    }
}