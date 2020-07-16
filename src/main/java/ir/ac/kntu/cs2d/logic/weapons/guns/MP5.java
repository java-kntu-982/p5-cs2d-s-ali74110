package ir.ac.kntu.cs2d.logic.weapons.guns;

public class MP5 extends Gun {
    public MP5() {
        this.setName("MP5");
        this.setPrice(1500);
        this.setDamage(13);
        this.setMillisToFireAgain(120);
        this.setMillisToReload(310);
        this.setMagazineCapacity(30);
    }
}
