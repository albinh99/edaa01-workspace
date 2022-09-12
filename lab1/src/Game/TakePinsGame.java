package Game;

public class TakePinsGame {
    public static void main(String[] args) {
        Board b = new Board(15);
        b.getNoPins();
        b.setUp(20);
        b.getNoPins();
        b.takePins(2);
        b.getNoPins();

    }
}
