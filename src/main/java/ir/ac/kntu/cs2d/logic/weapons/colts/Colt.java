package ir.ac.kntu.cs2d.logic.weapons.colts;

import ir.ac.kntu.cs2d.logic.weapons.Weapon;

import java.io.Serializable;

public class Colt extends Weapon implements Serializable {

    public Colt() {

    }

    @Override
    public void fire() {
        this.increaseBulletsFired();
    }

    @Override
    public void reload() {
        this.resetBulletsFired();
    }
}
