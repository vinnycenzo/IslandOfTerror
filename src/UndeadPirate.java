import java.util.Random;
public class UndeadPirate extends Enemy {
    public UndeadPirate() {
        super( 10, 10, "Double Shot");
        this.setName("Undead Pirate");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s shoots you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and groaning.%n", getName());
        }
    }
}