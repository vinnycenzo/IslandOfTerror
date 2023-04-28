import java.util.Random;

public class WeaponGenerator {
    private static final String[] WEAPON_NAMES = {"Sword", "Axe", "Mace", "Dagger"};

    public static Weapon generateWeapon() {
        Random random = new Random();
        String name = WEAPON_NAMES[random.nextInt(WEAPON_NAMES.length)];
        int damage = random.nextInt(10) + 1;
        return new Weapon(name, damage);
    }
}
