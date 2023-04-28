import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("map.txt");
        Island island = new Island(file);

        // get the starting row and column of the player
        int playerStartRow = island.getPlayerStartRow();
        int playerStartCol = island.getPlayerStartCol();

        // print the map with the player starting position
        island.printMap(playerStartRow, playerStartCol);
    }
}
