package Game;


import java.util.Random;
import java.util.Scanner;

public class TakePinsGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        Board b = new Board(15);
        HumanPlayer hp = new HumanPlayer("Ludvig");
        ComputerPlayer cp = new ComputerPlayer("botAlbin");

        while (b.getNoPins()>0){
            System.out.println("brädet har " + b.getNoPins() + " pinnar");
            int r = rand.nextInt(2)+1;
            System.out.println(hp.getUserId() + " tar pinnar: ");
            hp.takePins(b,scan.nextInt());
            System.out.println(b.getNoPins());
            cp.takePins(b, r);
            System.out.println(cp.getUserId() +" tog " + r +" pinnar ");
            System.out.println("pinnar kvar " + b.getNoPins());



        }

    }
}
