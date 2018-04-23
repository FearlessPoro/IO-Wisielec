package logic;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public enum SoundEffect {
    BAD_LETTER("sounds/battle003.wav"),
    GOOD_LETTER("sounds/battle003.wav"),
    GAME_LOST("sounds/battle003.wav"),
    GAME_WON("sounds/battle003.wav");

    private Clip clip;

    SoundEffect(String soundFileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
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