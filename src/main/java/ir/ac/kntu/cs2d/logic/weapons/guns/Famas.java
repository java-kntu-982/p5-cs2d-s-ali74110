package ir.ac.kntu.cs2d.logic.weapons.guns;

public class Famas extends Gun {
    public Famas() {
        this.setName("Famas");
        this.setPrice(2250);
        this.setDamage(14);
        this.setMillisToFireAgain(120);
        this.setMillisToReload(330);
        this.setMagazineCapacity(25);
    }
}
