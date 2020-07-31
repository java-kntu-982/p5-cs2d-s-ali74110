package ir.ac.kntu.cs2d.logic.play.logic;

import ir.ac.kntu.cs2d.logic.weapons.Group;
import ir.ac.kntu.cs2d.logic.weapons.Weapon;
import ir.ac.kntu.cs2d.logic.weapons.colts.Colt;
import ir.ac.kntu.cs2d.logic.weapons.colts.Glock;
import ir.ac.kntu.cs2d.logic.weapons.colts.USP;
import ir.ac.kntu.cs2d.logic.weapons.guns.Gun;

import java.io.Serializable;

public class Soldier implements Movable, Serializable {
    private double x ;
    private double y ;
    private String name;
    private Cash cash ;
    private Gun mainGun;
    private Colt pistol;
    private Weapon inHandWeapon;
    private Group group;
    private int soldiersKilledNum;
    private int health;

    public Soldier(String name , Group group) {
        this.health = 100;
        this.cash = new Cash();
        this.group = group;
        this.name = name;
        if (group == Group.COUNTER_TERRORIST){
            this.pistol = new USP();
            this.mainGun = new Gun();
            this.x = 170;
            this.y = 200;
        }else if (group == Group.TERRORIST){
            this.pistol = new Glock();
            this.mainGun = new Gun();
            this.x = 750;
            this.y = 300;
        }
        this.inHandWeapon = this.pistol;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void goUp() {
        y-=1.5;
    }

    @Override
    public void goDown() {
        y+=1.5;
    }

    @Override
    public void goRight() {
        x+=1.5;
    }

    @Override
    public void goLeft() {
        x-=1.5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public Gun getMainGun() {
        return mainGun;
    }

    public void setMainGun(Gun mainGun) {
        this.mainGun = mainGun;
    }

    public Colt getPistol() {
        return pistol;
    }

    public void setPistol(Colt pistol) {
        this.pistol = pistol;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setSoldiersKilledNum(int soldiersKilledNum) {
        this.soldiersKilledNum = soldiersKilledNum;
    }

    public int getSoldiersKilledNum() {
        return soldiersKilledNum;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setInHandWeapon(int inHandWeapon) {
        if (inHandWeapon == 1){
            this.inHandWeapon = mainGun;
        }else if (inHandWeapon == 2){
            this.inHandWeapon = pistol;
        }
    }

    public int getInHandWeapon() {
        if (inHandWeapon.equals(mainGun)) {
            return 1;
        } else if (inHandWeapon.equals(pistol)) {
            return 2;
        }
        return 0;
    }
}
