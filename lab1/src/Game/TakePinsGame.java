package Game;

public class TakePinsGame {

    public static void main(String[] args) {
        Board b = new Board(5);
        HumanPlayer hp = new HumanPlayer("Ludvig");
        ComputerPlayer cp = new ComputerPlayer("Albin");
        UserInterface.printMessage("Välkommen till spelet!" + "\n" + "Brädet har " + b.getNoPins() + " pinnar" + "\n" + "Du börjar. Ta en eller två pinnar");


        while (true) {
            if(b.getNoPins()!=0) {
                int c = hp.takePins(b);
                if (c == -2) {
                    System.exit(0);
                } else {
                    b.takePins(c);
                }
            }
            if(b.getNoPins()!=0){
                int a = cp.takePins(b);
                b.takePins(a);
                UserInterface.printMessage("Datorn tog " + a + " pinnar" + "\n" + "Det finns " + b.getNoPins() + " kvar!" + "\n" + "Din tur!");
                if(b.getNoPins() == 0) {
                    UserInterface.printMessage("Datorn har vunnit");
                }
            }
            else{
                break;
            }


        }
    }
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

