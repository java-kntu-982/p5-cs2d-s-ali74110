package ir.ac.kntu.cs2d.logic.play.logic;

import ir.ac.kntu.cs2d.graphics.Observer;
import ir.ac.kntu.cs2d.logic.Observable;
import ir.ac.kntu.cs2d.logic.weapons.Group;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Game extends TimerTask implements Observable<Game> , Serializable {

    private List<Observer<Game>> observers;
    private List<Soldier> soldiers;
    private Aim aim;
    private SoldierAim soldierAim;
    private Camera camera;
    private String inGameSoldiers = "";
    private Map map;

    public Game() throws FileNotFoundException {
        soldiers = new ArrayList<>();
        observers = new ArrayList<>();
        aim = new Aim(400,400,5);
        soldierAim = new SoldierAim(0,0,1,1);
        camera = new Camera();
        map = new Map();
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
        for (Soldier soldier : soldiers){

            if (soldier.getX()<=8){
                soldier.setX(9);
            }else if (soldier.getX()>=792){
                soldier.setX(791);
            }
            if (soldier.getY()<=8){
                soldier.setY(9);
            }else if (soldier.getY()>=792){
                soldier.setY(791);
            }

            inGameSoldiers = "" ;
            if (soldier.getHealth()<=0){
                inGameSoldiers += soldier.getName()+"(dead)\n";
            }else {
                inGameSoldiers += soldier.getName()+'('+soldier.getHealth()+")\n";
            }

            if (aim.getX()<=12){
                aim.setX(13);
            }else if (aim.getX()>=788){
                aim.setX(787);
            }
            if (aim.getY()<=12){
                aim.setY(13);
            }else if (aim.getY()>=788){
                aim.setY(787);
            }
            for (Obstacle obstacle : map.getObstacles()){
                if (soldier.getX()+8>=obstacle.getX() &&
                        soldier.getY()+8>=obstacle.getY() &&
                        soldier.getX()-8<=obstacle.getX()+obstacle.getWidth() &&
                        soldier.getY()-8<=obstacle.getY()+obstacle.getHeight() ){
//                    if (soldier.getY()>obstacle.getY())
                    if (soldier.getY()>=obstacle.getY() && soldier.getY()-8<=obstacle.getY()+obstacle.getHeight()
                            && soldier.getX()-8<=obstacle.getX()+5){
                        soldier.setX(soldier.getX()-2);
                    } else if (soldier.getY()+8>=obstacle.getY() && soldier.getY()-8<=obstacle.getY()+obstacle.getHeight()
                            && soldier.getX()+8>=obstacle.getX()-5){
                        soldier.setX(soldier.getX()+2);
                    }
                     if ( soldier.getX()+8>=obstacle.getX() && soldier.getX()-8<=obstacle.getX()+obstacle.getWidth()
                            && soldier.getY()-8<=obstacle.getY()){
                        soldier.setY(soldier.getY()-2);
                        soldier.setX(soldier.getX()-2);
                    }else if ( soldier.getX()+8>=obstacle.getX() && soldier.getX()-8<=obstacle.getX()+obstacle.getWidth()
                            && soldier.getY()+8>=obstacle.getY()){
                         soldier.setY(soldier.getY()+2);
                         soldier.setX(soldier.getX()-2);
                     }
                }
            }
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
