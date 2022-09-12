package Game;


import java.util.Random;
import java.util.Scanner;

public class TakePinsGame {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    public static void main(String[] args) {

        Board b = new Board(15);
        b.getNoPins();
        b.setUp(20);
        b.getNoPins();
        b.takePins(2);
        b.getNoPins();

    }
}
