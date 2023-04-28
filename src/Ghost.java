import java.util.Random;
public class Ghost extends Enemy {
    public Ghost() {
        super(15, 15, "Haunt");
        this.setName("Ghost");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s haunts you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and floating.%n", getName());
        }
    }
}
