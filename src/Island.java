import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Island {
    private char[][] map;
    private int playerStartRow;
    private int playerStartCol;
    private Enemy[] enemies;
    private List<Weapon> weapons = new ArrayList<>();
    public Island(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        scanner.nextLine();

        map = new char[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < numCols; col++) {
                map[row][col] = line.charAt(col);
                if (map[row][col] == 'P') {
                    playerStartRow = row;
                    playerStartCol = col;
                }
            }
        }
        scanner.close();
    }

    public char[][] getMap() {
        return map;
    }

    public int getHeight() {
        return map.length;
    }

    public int getWidth() {
        return map[0].length;
    }

    public void printMap(int playerRow, int playerCol) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (row == playerRow && col == playerCol) {
                    System.out.print("P ");
                } else {
                    System.out.print(map[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    public int getPlayerStartRow() {
        return playerStartRow;
    }

    public int getPlayerStartCol() {
        return playerStartCol;
    }

    public boolean checkWin(int row, int col) {
        return map[row][col] == 'D';
    }

    public void addEnemy(Enemy enemy) {
        if (enemies == null) {
            enemies = new Enemy[]{enemy};
        } else {
            Enemy[] temp = new Enemy[enemies.length + 1];
            for (int i = 0; i < enemies.length; i++) {
                temp[i] = enemies[i];
            }
            temp[enemies.length] = enemy;
            enemies = temp;
        }


    }
    public void removeWeapon(Weapon weapon) {
        for (int i = 0; i < weapons.size(); i++) {
            Weapon currentWeapon = weapons.get(i);
            if (currentWeapon.getName().equals(weapon.getName())) {
                weapons.remove(i);
                break;
            }
        }
    }


}

