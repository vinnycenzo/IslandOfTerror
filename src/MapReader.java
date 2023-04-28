import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapReader {
    private static final int ROWS = 7;
    private static final int COLUMNS = 7;
    private static final char EMPTY = ' ';
    private static final char ENEMY = 'E';
    private static final char PLAYER = 'P';
    private static final char WEAPON = 'W';

    private char[][] map;

    public MapReader(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        map = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < COLUMNS; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        scanner.close();
    }

    public char[][] getMap() {
        return map;
    }

    public int getStartRow() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (map[i][j] == PLAYER) {
                    return i;
                }
            }
        }
        return -1; // Player not found
    }

    public int getStartCol() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (map[i][j] == PLAYER) {
                    return j;
                }
            }
        }
        return -1; // Player not found
    }

    public int getEnemyCount() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (map[i][j] == ENEMY) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getWeaponCount() {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (map[i][j] == WEAPON) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isLocationEmpty(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS) {
            return false;
        }
        return map[row][col] == EMPTY;
    }

    public void setLocation(int row, int col, char symbol) {
        map[row][col] = symbol;
    }

    public void clearLocation(int row, int col) {
        map[row][col] = EMPTY;
    }
}
