import java.util.Random;
public class WildBoar extends Enemy {
    public WildBoar() {
        super(15, 10, "Charge");
        this.setName("Wild Boar");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s charges you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and making boar noises.%n", getName());
        }
    }
}