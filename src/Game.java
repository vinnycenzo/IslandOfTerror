import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;


public class Game {
    private Island island;

    private Player player;
    private Scanner scanner;
    private boolean[][] enemyPositions;
    int totalGoldCoins = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    public Game() {
        scanner = new Scanner(System.in);
        try {
            island = new Island(new File("map.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not load map file.");
            e.printStackTrace();
            System.exit(0);
        }

        if (island.getMap() == null) {
            System.out.println("Error: Map file not loaded successfully.");
            System.exit(0);
        }

        int playerStartRow = island.getPlayerStartRow();
        int playerStartCol = island.getPlayerStartCol();
        player = new Player(playerStartRow, playerStartCol, 200, 5);
        enemyPositions = new boolean[island.getHeight()][island.getWidth()];
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            island.printMap(player.getRow(), player.getCol());
            String[] weaponNames = {"Sword", "Axe", "Mace", "Bow"};
            Random random = new Random();

            // Check if player is on an "E" square
            if (island.getMap()[player.getRow()][player.getCol()] == 'E' && !enemyPositions[player.getRow()][player.getCol()]) {
                spawnEnemy();
                island.getMap()[player.getRow()][player.getCol()] = 'X';
            }
            if (island.getMap()[player.getRow()][player.getCol()] == 'W') {
                Weapon newWeapon = WeaponGenerator.generateWeapon();
               // player.pickupWeapon(newWeapon);
                System.out.println("You picked up a " + newWeapon.getName() + "!");
                island.getMap()[player.getRow()][player.getCol()] = 'X';
            }
            if (island.getMap()[player.getRow()][player.getCol()] == 'T') {
                totalGoldCoins += 5;
                System.out.println("You found 5 gold coins! You now have " + totalGoldCoins + " gold coins.");
                island.getMap()[player.getRow()][player.getCol()] = 'X';
            }

            System.out.println("Enter a command (W/A/S/D) or Q to quit:");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "W":
                    if (player.getRow() > 0) {
                        player.moveNorth();
                    } else {
                        System.out.println("You can't go further North.");
                    }
                    break;
                case "S":
                    if (player.getRow() < island.getHeight() - 1) {
                        player.moveSouth();
                    } else {
                        System.out.println("You can't go further South.");
                    }
                    break;
                case "D":
                    if (player.getCol() < island.getWidth() - 1) {
                        player.moveEast();
                    } else {
                        System.out.println("You can't go further East.");
                    }
                    break;
                case "A":
                    if (player.getCol() > 0) {
                        player.moveWest();
                    } else {
                        System.out.println("You can't go further West.");
                    }
                    break;
                case "Q":
                    gameOver = true;
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }

            if (island.checkWin(player.getRow(), player.getCol())) {
                System.out.println("Congratulations! You've escaped the Island of Terror!");
                gameOver = true;
            }
        }
    }

    private Weapon playerWeapon;

    private void spawnEnemy() {
        int row = player.getRow();
        int col = player.getCol();
        if (island.getMap()[row][col] == 'E') {
            int enemyType = (int) (Math.random() * 7) + 1;
            Enemy enemy;
            String enemyName;
            switch (enemyType) {
                case 1:
                    enemy = new Ghost();
                    enemyName = "Ghost";
                    break;
                case 2:
                    enemy = new GiantCrab();
                    enemyName = "Giant Crab";
                    break;
                case 3:
                    enemy = new Shark();
                    enemyName = "Shark";
                    break;
                case 4:
                    enemy = new Siren();
                    enemyName = "Siren";
                    break;
                case 5:
                    enemy = new Skeleton();
                    enemyName = "Skeleton";
                    break;
                case 6:
                    enemy = new Snake();
                    enemyName = "Snake";
                    break;
                case 7:
                    enemy = new UndeadPirate();
                    enemyName = "Undead Pirate";
                    break;
                case 8:
                    enemy = new WildBoar();
                    enemyName = "Wild Boar";
                    break;
                default:
                    enemy = null;
                    enemyName = "Unknown Enemy";
                    break;
            }
            if (enemy != null) {
                if (enemyPositions[player.getRow()][player.getCol()]) {
                    System.out.println("An " + enemyName + " has already spawned here.");
                } else {
                    System.out.println("A " + enemyName + " has spawned!");
                    island.addEnemy(enemy);
                    enemyPositions[player.getRow()][player.getCol()] = true;
                    enemy.setName(enemyName);
                    enemy.fight(player);
                    enemyPositions[row][col] = false;
                }
            }
        }
    }
}