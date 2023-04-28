import java.util.List;
import java.util.ArrayList;

public class Room {
    private String description;
    private boolean accessible;
    private Weapon weapon;
    private Enemy enemy;

    public Room(String description, boolean accessible) {
        this.description = description;
        this.accessible = accessible;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void removeWeapon() {
        this.weapon = null;
    }

    public boolean hasWeapon() {
        return weapon != null;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void removeEnemy() {
        this.enemy = null;
    }

    public boolean hasEnemy() {
        return enemy != null;
    }
}
