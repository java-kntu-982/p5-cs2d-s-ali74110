package ir.ac.kntu.cs2d.logic.weapons.guns;

import ir.ac.kntu.cs2d.logic.weapons.Group;
import ir.ac.kntu.cs2d.logic.weapons.Weapon;

public class Gun extends Weapon {

    private Group group;

    public Gun(){
        this.setName("-no main Gun-");
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
