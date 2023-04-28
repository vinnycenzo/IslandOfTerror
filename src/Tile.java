public class Tile {
    private boolean isWalkable;
    private String description;
    private Weapon weapon;

    public Tile(boolean isWalkable, String description, Weapon weapon) {
        this.isWalkable = isWalkable;
        this.description = description;
        this.weapon = weapon;
    }

    public boolean isWalkable() {
        return isWalkable;
    }

    public String getDescription() {
        return description;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
