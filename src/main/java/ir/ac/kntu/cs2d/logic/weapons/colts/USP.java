package ir.ac.kntu.cs2d.logic.weapons.colts;

public class USP extends Colt{
    public USP () {
        this.setName("USP");
        this.setPrice(500);
        this.setDamage(24);
        this.setMillisToFireAgain(340);
        this.setMillisToReload(220);
        this.setMagazineCapacity(12);
    }
}
