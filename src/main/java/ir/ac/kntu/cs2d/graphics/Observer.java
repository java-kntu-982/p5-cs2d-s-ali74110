package ir.ac.kntu.cs2d.graphics;

import ir.ac.kntu.cs2d.logic.Observable;

public interface Observer<T extends Observable<?>> {
    void update(T observable);
}

