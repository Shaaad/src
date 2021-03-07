package model;

public interface Subject {
    void notifyAllObservers(); //Выполняет update для кажного компонента
    void attach(Observer obs);
    void detach(Observer obs);
    int getState();
}

