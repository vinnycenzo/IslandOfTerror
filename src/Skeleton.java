import java.util.Random;
public class Skeleton extends Enemy {
    public Skeleton() {
        super(15, 10, "Bone toss");
        this.setName("Skeleton");
    }
    @Override
    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(getDamage()) + 1;
        player.takeDamage(damage);
        System.out.printf("%s hits you for %d damage.%n", getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isDefeated()) {
            System.out.printf("%s is still alive and clunking around.%n", getName());
        }
    }
}