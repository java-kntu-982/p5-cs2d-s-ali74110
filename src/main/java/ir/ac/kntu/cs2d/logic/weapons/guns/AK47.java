package ir.ac.kntu.cs2d.logic.weapons.guns;

public class AK47 extends Gun {
    public AK47() {
        this.setName("AK47");
        this.setPrice(2500);
        this.setDamage(22);
        this.setMillisToFireAgain(120);
        this.setMillisToReload(250);
        this.setMagazineCapacity(30);
    }
}
