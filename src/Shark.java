import java.util.Random;
public class Shark extends Enemy {
    public Shark() {
        super(10, 15, "Tail Whip");
        this.setName("Shark");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s tail whips you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and swimming.%n", getName());
        }
    }
}