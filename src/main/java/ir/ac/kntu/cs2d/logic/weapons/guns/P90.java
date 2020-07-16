package ir.ac.kntu.cs2d.logic.weapons.guns;

public class P90 extends Gun {
    public P90() {
        this.setName("P90");
        this.setPrice(2350);
        this.setDamage(11);
        this.setMillisToFireAgain(80);
        this.setMillisToReload(330);
        this.setMagazineCapacity(50);
    }
}
