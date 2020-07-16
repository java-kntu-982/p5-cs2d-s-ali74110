package ir.ac.kntu.cs2d.logic.weapons.colts;

import ir.ac.kntu.cs2d.logic.weapons.Weapon;

public class Colt extends Weapon {

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
