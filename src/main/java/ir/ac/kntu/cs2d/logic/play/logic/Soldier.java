package ir.ac.kntu.cs2d.logic.play.logic;

import ir.ac.kntu.cs2d.logic.weapons.Group;
import ir.ac.kntu.cs2d.logic.weapons.Weapon;
import ir.ac.kntu.cs2d.logic.weapons.colts.Colt;
import ir.ac.kntu.cs2d.logic.weapons.colts.Glock;
import ir.ac.kntu.cs2d.logic.weapons.colts.USP;
import ir.ac.kntu.cs2d.logic.weapons.guns.Gun;

public class Soldier implements Movable{
    private double x ;
    private double y ;
    private String name;
    private Cash cash ;
    private Gun mainGun;
    private Colt pistol;
    private Weapon inHandWeapon;
    private Group group;

    public Soldier(String name , Group group,double x, double y) {
        this.x = x;
        this.y = y;
        cash = new Cash();
        this.group = group;
        this.name = name;
        if (group == Group.COUNTER_TERRORIST){
            pistol = new USP();
            mainGun = new Gun();
        }else if (group == Group.TERRORIST){
            pistol = new Glock();
            mainGun = new Gun();
        }
        inHandWeapon = pistol;
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
        y--;
    }

    @Override
    public void goDown() {
        y++;
    }

    @Override
    public void goRight() {
        x++;
    }

    @Override
    public void goLeft() {
        x--;
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
