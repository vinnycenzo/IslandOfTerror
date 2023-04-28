import java.util.Random;
public class Siren extends Enemy {
    public Siren() {
        super( 10, 10, "Siren's Song");
        this.setName("Siren");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s serenades you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and singing.%n", getName());
        }
    }
}