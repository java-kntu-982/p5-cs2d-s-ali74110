package ir.ac.kntu.cs2d.logic.weapons;

import ir.ac.kntu.cs2d.logic.Firable;
import ir.ac.kntu.cs2d.logic.Reloadable;

public abstract class Weapon implements Firable, Reloadable {
    private String name;
    private int magazineCapacity;
    private int damage;
    private int price;
    private int millisToFireAgain;
    private int millisToReload;
    private int bulletsFired = 0;

    public Weapon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public void setMagazineCapacity(int magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMillisToFireAgain() {
        return millisToFireAgain;
    }

    public void setMillisToFireAgain(int millisToFireAgain) {
        this.millisToFireAgain = millisToFireAgain;
    }

    public int getMillisToReload() {
        return millisToReload;
    }

    public void setMillisToReload(int secondsToReload) {
        this.millisToReload = secondsToReload;
    }

    public int getBulletsFired() {
        return bulletsFired;
    }

    public void resetBulletsFired() {
        this.bulletsFired = 0;
    }

    public void increaseBulletsFired() {
        this.bulletsFired ++;
    }

}
