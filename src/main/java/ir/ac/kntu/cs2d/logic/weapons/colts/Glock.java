package ir.ac.kntu.cs2d.logic.weapons.colts;

public class Glock extends Colt{

    public Glock() {
        this.setName("Glock");
        this.setPrice(400);
        this.setDamage(21);
        this.setMillisToFireAgain(300);
        this.setMillisToReload(230);
        this.setMagazineCapacity(20);
    }
}
