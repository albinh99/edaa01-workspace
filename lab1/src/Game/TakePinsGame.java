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
        System.out.println("Brädet har " + b.getNoPins() + " pinnar");
        //Skapar ett bräde och 2 spelare samt meddelar hur många pinnar brädet börjar med

        while (b.getNoPins()>=0) { // ska vi ha =0?
            if (b.getNoPins() > 0) {
                System.out.println(hp.getUserId() + " tar pinnar: ");
                int f;
                while (true) {
                    f = scan.nextInt();
                    if (f <= 2  && b.getNoPins() - f >= 0 && f!=0) {
                        break;
                    } else {
                        System.out.println("Du måste ta en eller två pinnar");
                    }
                }
                hp.takePins(b, f);
                System.out.println(b.getNoPins());
            } else {
                System.out.println(cp.getUserId() + " har vunnit!");
                break;
            }

            if(b.getNoPins()>0 && b.getNoPins()!= 1) {
                int r = rand.nextInt(2) + 1;
                cp.takePins(b, r);
                System.out.println(cp.getUserId() + " tog " + r + " pinnar ");
                System.out.println("Antal pinnar kvar: " + b.getNoPins());

            }
            else if(b.getNoPins() == 1){
                cp.takePins(b,1);
                System.out.println(cp.getUserId() + " har vunnit!");
                break;

            }
        }

    }
}
