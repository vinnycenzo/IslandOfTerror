import java.util.Random;
import java.util.List;
import java.util.ArrayList;



public class Player {
    private String name;
    private List<Weapon> inventory;
    private List<Weapon> weapons;

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }

    public void pickupWeapon(Weapon newWeapon) {
        inventory.add(newWeapon);
        weapons.add(newWeapon);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Weapon> getInventory() {
        return inventory;
    }



private int row;
    private int col;
    private int hp;
    private int maxHp;
    private int damage;
   // private List<Weapon> weapons;
    private List<Treasure> treasure;
    private String weapon;

    public Player(int row, int col, int hp, int damage) {
        this.row = row;
        this.col = col;
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDamage() {
        return damage;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    //    System.out.printf("You take %d damage.%n", damage);
    }

    public boolean isDefeated() {
        return hp <= 0;
    }

    public void attack(Enemy enemy) {
        Random random = new Random();
        int damage = random.nextInt(this.damage) + 1;
        enemy.takeDamage(damage);
        System.out.printf("You attack %s for %d damage.%n", enemy.getName(), damage);
    }
    public int[] fight(Player player) {
        int[] result = new int[2];
        while (hp > 0 && player.getHp() > 0) {
            // Enemy attacks player
            int damageToPlayer = (int) (Math.random() * damage);
            player.takeDamage(damageToPlayer);
            System.out.println("You have been attacked for " + damageToPlayer + " damage!");
            System.out.println("Your health is now " + player.getHp());

            if (player.getHp() <= 0) {
                break;
            }

            // Player attacks enemy
            int damageToEnemy = (int) (Math.random() * player.getDamage());
            takeDamage(damageToEnemy);
            System.out.println("You attack the enemy for " + damageToEnemy + " damage!");
            System.out.println("The enemy's health is now " + hp);
        }
        result[0] = hp;
        result[1] = player.getHp();
        return result;
    }
        public void addToTreasure(Treasure newTreasure) {
            if (treasure == null) {
                treasure = new ArrayList<>();
            }
            treasure.add(newTreasure);
        }

    public int getTreasureAmt(Player player) {
        if (treasure == null) {
            System.out.println("No treasure found.");
            return 0;
        }
        int totalAmt = 0;
        for (Treasure t : treasure) {
            totalAmt += t.getAmt();
        }

        return totalAmt + player.getTreasureAmt(player);
    }



  //  public void pickupWeapon(Weapon newWeapon) {
 //       inventory.addItem(newWeapon);
  //      if (this.weapons == null) {
  //          this.weapons = new ArrayList<>();
  //      }
   //     this.weapons.add(newWeapon);
  //  }


    public String getWeaponsList() {
        if (this.weapons == null || this.weapons.isEmpty()) {
            return "No weapons";
        }
        StringBuilder sb = new StringBuilder();
        for (Weapon w : this.weapons) {
            sb.append(w.getName()).append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }





    public void moveNorth() {
        row--;
    }

    public void moveSouth() {
        row++;
    }

    public void moveEast() {
        col++;
    }

    public void moveWest() {
        col--;
    }

    public void interactWithEnemy(Enemy enemy) {
        System.out.printf("You have encountered a %s!%n", enemy.getName());
        while (!isDefeated() && !enemy.isDefeated()) {
            attack(enemy);
            if (enemy.isDefeated()) {
                System.out.printf("You have defeated the %s!%n", enemy.getName());
                break;
            }
            enemy.attack(this);
            if (isDefeated()) {
                System.out.println("You have been defeated...");
            }
        }
    }
}
