package ir.ac.kntu.cs2d.logic.play.logic;

import java.io.Serializable;

public class Cash implements Serializable {
    private int amount = 800;

    public int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
        if (this.amount>18000){
            this.amount = 18000;
        }
    }

    public void increaseCash(int amount){
        this.setAmount(this.getAmount() + amount);
    }

    public void decreaseCash(int amount){
        this.setAmount(this.getAmount() - amount);
    }
}

