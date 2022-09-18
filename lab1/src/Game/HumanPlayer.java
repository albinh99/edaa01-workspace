package Game;

public class HumanPlayer extends Player{

    protected HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int takePins(Board bräda) {
        while (true){

            int intInput = UserInterface.askForInt("din tur ");

            if (bräda.getNoPins() - intInput < 0){
                UserInterface.printMessage("Går ej att ta 2, bara en pinner kvar!");
            }
            else if (bräda.getNoPins() - intInput == 0){
                UserInterface.printMessage("Grattis! Du har vunnit");

            }
            else {
                return intInput;
            }

        }

    }



}
