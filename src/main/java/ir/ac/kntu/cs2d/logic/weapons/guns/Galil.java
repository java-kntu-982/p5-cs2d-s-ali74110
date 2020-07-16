package ir.ac.kntu.cs2d.logic.weapons.guns;

public class Galil extends Gun {
    public Galil() {
        this.setName("Galil");
        this.setPrice(2000);
        this.setDamage(13);
        this.setMillisToFireAgain(120);
        this.setMillisToReload(260);
        this.setMagazineCapacity(35);
    }
}
