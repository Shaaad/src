package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.Timer;
import java.util.TimerTask;

public class ComponentMusic implements Observer {

    private String musicFile;
    private AudioClip audioClip;
    private TimerTask task;
    private Timer timer = new Timer();
    private Image play = new Image("/resources/play.jpg");
    private Image stop = new Image("/resources/stop.jpg");
    private ImageView iv;

    public ComponentMusic(String musicFile, ImageView iv) {
        this.musicFile = musicFile;
        audioClip = new AudioClip(this.getClass().getResource(musicFile).toExternalForm());
        this.iv = iv;
    }

    public void play() {
        audioClip.play();
    }

    public void stop() { audioClip.stop(); }

    @Override
    public void update(Subject st) {
        if (st.getState() % 20 == 0) {
            ComponentMusic cm = this;
            cm.play();
            iv.setImage(play);
            task = new TimerTask() {
                @Override
                public void run() {
                   cm.stop();
                    iv.setImage(stop);
                }
            };
            timer.schedule(task,2500);
        }
    }
}
