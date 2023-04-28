
import java.util.Random;
public class Snake extends Enemy {
    public Snake() {
        super(5, 5, "Venom Spit");
        this.setName("Snake");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s spits at you and burns you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and hissing.%n", getName());
        }
    }
}
