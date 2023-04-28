import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> weapons;

    public Inventory() {
        this.weapons = new HashMap<String, Integer>();
    }
    private void displayInventory(Player player) {
        System.out.println("Your inventory:");
        System.out.println(player.getInventory());
    }

    public void addWeapon(String weapon) {
        if (this.weapons.containsKey(weapon)) {
            int count = this.weapons.get(weapon);
            this.weapons.put(weapon, count + 1);
        } else {
            this.weapons.put(weapon, 1);
        }
    }


    public HashMap<String, Integer> getWeapons() {
        return this.weapons;
    }
}
