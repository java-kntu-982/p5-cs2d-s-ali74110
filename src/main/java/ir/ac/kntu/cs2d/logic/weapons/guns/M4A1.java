package ir.ac.kntu.cs2d.logic.weapons.guns;

public class M4A1 extends Gun {
    public M4A1() {
        this.setName("M4A1");
        this.setPrice(3100);
        this.setDamage(22);
        this.setMillisToFireAgain(120);
        this.setMillisToReload(310);
        this.setMagazineCapacity(30);
    }
}
