package ir.ac.kntu.cs2d.logic;


import ir.ac.kntu.cs2d.graphics.Observer;

public interface Observable<SELF extends Observable<?>> {
    void addObserver(Observer<SELF> observer);

    void updateAllObservers();
}
