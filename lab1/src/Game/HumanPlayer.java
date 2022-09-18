package Game;

public class HumanPlayer extends Player{

    protected HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int takePins(Board bräda) {
        while (true){

            int intInput = UserInterface.askForInt("Din tur");

            if (bräda.getNoPins() - intInput < 0){
                UserInterface.printMessage("Det finns bara en pinne kvar");
            }
            else if (bräda.getNoPins() - intInput == 0){
                UserInterface.printMessage("Grattis! Du har vunnit");
                return intInput;

            }
            else {
                return intInput;
            }

        }

    }



}
