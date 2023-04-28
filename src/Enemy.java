import java.util.Random;

public class Enemy {
    private String name;
    private int hp;
    private int maxHp;
    private int damage;
    private String ability;

    public Enemy(int hp, int damage, String ability) {
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
        this.ability = ability;
        setName("Enemy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDamage() {
        return damage;
    }

    public String getAbility() {
        return ability;
    }

    public void attack(Player player) {
        Random random = new Random();
        int damage = random.nextInt(this.damage) + 1;
        player.takeDamage(damage);
        System.out.printf("%s attacks you for %d damage.%n", name, damage);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.printf("%s takes %d damage.%n", name, damage);
    }

    public boolean isDefeated() {
        return hp <= 0;
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
        System.out.printf("%s heals for %d health.%n", name, amount);
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void fight(Player player) {
        System.out.printf("%s appears!%n", name);

        while (!this.isDefeated() && !player.isDefeated()) {
            this.attack(player);
            if (player.isDefeated()) {
                break;
            }

            System.out.println("Your turn:");
            player.attack(this);

            if (this.isDefeated()) {
                System.out.printf("%s has been defeated!%n", name);
                break;
            }

            System.out.println();
        }
    }
}
