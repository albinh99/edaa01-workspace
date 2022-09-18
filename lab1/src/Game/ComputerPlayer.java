package Game;

import java.util.Random;

public class ComputerPlayer extends Player{

    protected Random rand = new Random();
    protected ComputerPlayer(String name) {
        super(name);

    }

    @Override
    public int takePins(Board bräda){


    if (bräda.getNoPins() == 1){
            return 1;
        }
        else if (bräda.getNoPins() == 2){
            return 2;
        } else if (bräda.getNoPins()==4) {
            return 1;
        } else if (bräda.getNoPins() == 5) {
            return 2;

        }
        else {return rand.nextInt(2) + 1;
        }
    }


}
