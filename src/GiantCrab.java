import java.util.Random;
public class GiantCrab extends Enemy {
    public GiantCrab() {
        super( 20, 15, "Crushing Claw");
        this.setName("Giant Crab");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s crushes you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and standing.%n", getName());
        }
    }
}