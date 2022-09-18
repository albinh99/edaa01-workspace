package Game;


import java.util.Random;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class TakePinsGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Board b = new Board(15);
        HumanPlayer hp = new HumanPlayer("Ludvig");
        ComputerPlayer cp = new ComputerPlayer("Albin");

        UserInterface.printMessage("Brädet har " + b.getNoPins() + " pinnar");


        while (true){

            int toint = UserInterface.askForInt("Ta 1 eller 2 pinnar", b.getNoPins());
            hp.takePins(b, toint);
            UserInterface.printMessage("" + b.getNoPins());


            if(b.getNoPins() == 0){
                UserInterface.printMessage(hp.getUserId() + " har vunnit!");
                break;
            }


            else if(b.getNoPins()>0 && b.getNoPins()!= 1) {
                int r = rand.nextInt(2) + 1;
                cp.takePins(b, r);
                UserInterface.printMessage(cp.getUserId() + " tog " + r + " pinnar ");
                UserInterface.printMessage("Antal pinnar kvar: " + b.getNoPins());

            }
            else if(b.getNoPins() == 1){
                cp.takePins(b,1);
                UserInterface.printMessage(cp.getUserId() + " har vunnit!");
                break;


        }








    /*
        while (b.getNoPins()>=0) {
            if (b.getNoPins() > 0) {
                showMessageDialog(null, hp.getUserId() + " tar pinnar: ");
                int f;
                while (true) {
                    String a = showInputDialog("Ta en eller två pinnar");

                    f = scan.nextInt();
                    if (f <= 2  && b.getNoPins() - f >= 0 && f!=0) {
                        break;
                    } else {
                        showMessageDialog(null, "Fel input");
                    }
                }
                hp.takePins(b, f);
                showMessageDialog(null,b.getNoPins());
            } else {
                showMessageDialog(null,cp.getUserId() + " har vunnit!");
                break;
            }

            if(b.getNoPins() == 0){
                showMessageDialog(null,hp.getUserId() + " har vunnit!");
                break;
            }


            else if(b.getNoPins()>0 && b.getNoPins()!= 1) {
                int r = rand.nextInt(2) + 1;
                cp.takePins(b, r);
                showMessageDialog(null,cp.getUserId() + " tog " + r + " pinnar ");
                showMessageDialog(null,"Antal pinnar kvar: " + b.getNoPins());

            }
            else if(b.getNoPins() == 1){
                cp.takePins(b,1);
                showMessageDialog(null,cp.getUserId() + " har vunnit!");
                break;

            }
        }*/

    }


}}
