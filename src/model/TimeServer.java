package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class TimeServer implements Subject {

    Timer timer;
    int delay,period;
    int timeState;
    List<Observer> observers = new LinkedList<Observer>();

    public TimeServer(){
        timeState=0;
        delay=1000;
        period=1000;
        timer = new Timer(delay, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                timeState++;
                notifyAllObservers();
            }
        });
    }

    public void start(){
        timer.start();

    }

    public void stop(){
        timer.stop();
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer: observers){
            observer.update(this);
        }
    }

    @Override
    public void attach(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public int getState() {
        return timeState;
    }
}

