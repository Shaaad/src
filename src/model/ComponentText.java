package model;

import javafx.scene.control.TextField;

public class ComponentText implements Observer {
    private TextField textField;
    private int hours;
    private int minutes;
    private int seconds;

    public ComponentText(TextField textField){

        this.textField = textField;
        seconds = 0;
        minutes = 0;
        hours = 0;
    }

    @Override
    public void update(Subject st) {
        double ticks = st.getState();
        hours = (int)Math.floor(ticks / 60 / 60);
        minutes = (int)Math.floor(ticks / 60);
        seconds = (int)(ticks % 60);
        textField.setText("Прошло " + hours + " часов, " + minutes + " минут, " + seconds + " секунд");
    }
}
