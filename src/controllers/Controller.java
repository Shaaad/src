package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.ComponentAnimation;
import model.ComponentMusic;
import model.ComponentText;
import model.TimeServer;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public Button startButton;
    public Button stopButton;
    public ImageView imageView;
    public TextField seconds;
    @FXML
    public Canvas canvas;

    private ComponentMusic cm;
    private ComponentText ct;
    private ComponentAnimation ca;
    private TimeServer timeServer = new TimeServer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ct = new ComponentText(seconds);
        cm = new ComponentMusic("/resources/Sound.mp3", imageView);
        ca = new ComponentAnimation(canvas.getGraphicsContext2D());
        timeServer.attach(ct);
        timeServer.attach(cm);
        timeServer.attach(ca);
        startButton.setOnAction(actionEvent ->  {
            timeServer.start();
        } );
        stopButton.setOnAction(actionEvent -> {
            timeServer.stop();
        } );
    }
}
