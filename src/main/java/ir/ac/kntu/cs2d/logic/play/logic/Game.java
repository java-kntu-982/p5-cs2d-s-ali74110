package ir.ac.kntu.cs2d.logic.play.logic;

import ir.ac.kntu.cs2d.graphics.Observer;
import ir.ac.kntu.cs2d.logic.Observable;
import ir.ac.kntu.cs2d.logic.weapons.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Game extends TimerTask implements Observable<Game> {

    private List<Observer<Game>> observers;
    private List<Soldier> soldiers;
    private Aim aim;
    private SoldierAim soldierAim;
    private Camera camera;
    private String inGameSoldiers = "";

    public Game(){
        soldiers = new ArrayList<>();
        observers = new ArrayList<>();
        Soldier soldier = new Soldier("ali", Group.TERRORIST,0,0);
        soldiers.add(soldier);
        aim = new Aim(0,0,5);
        soldierAim = new SoldierAim(0,0,1,1);
        camera = new Camera();
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    @Override
    public void addObserver(Observer<Game> observer) {
        observers.add(observer);
    }

    @Override
    public void updateAllObservers() {
        observers.forEach(z -> z.update(this));
    }

    @Override
    public void run() {
        if (soldiers.get(0).getX()<=8){
            soldiers.get(0).setX(9);
        }else if (soldiers.get(0).getX()>=592){
            soldiers.get(0).setX(591);
        }
        if (soldiers.get(0).getY()<=108){
            soldiers.get(0).setY(109);
        }else if (soldiers.get(0).getY()>=692){
            soldiers.get(0).setY(691);
        }
        inGameSoldiers = "" ;
        for (Soldier soldier : soldiers){
            if (soldier.getHealth()<=0){
                inGameSoldiers += soldier.getName()+"(dead)\n";
            }else {
                inGameSoldiers += soldier.getName()+'('+soldier.getHealth()+")\n";
            }
        }
        if (aim.getX()<=12){
            aim.setX(13);
        }else if (aim.getX()>=588){
            aim.setX(587);
        }
        if (aim.getY()<=112){
            aim.setY(113);
        }else if (aim.getY()>=688){
            aim.setY(687);
        }

        updateAllObservers();
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public Aim getAim() {
        return aim;
    }

    public void setAim(Aim aim) {
        this.aim = aim;
    }

    public SoldierAim getSoldierAim() {
        return soldierAim;
    }

    public void setSoldierAim(SoldierAim soldierAim) {
        this.soldierAim = soldierAim;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getInGameSoldiers() {
        return inGameSoldiers;
    }
}
