package Game;

import static javax.swing.JOptionPane.*;

public class UserInterface {
    public static void printMessage(String msg){
        showMessageDialog(null,msg);

    }

    public static int askForInt(String msg, int nopins){
        int toInt;
        String inputMsg;
        //int c = 0;
        while(true){

            inputMsg = showInputDialog(msg);
            if(inputMsg.equals("1")||inputMsg.equals("2")){
                toInt = Integer.parseInt(inputMsg);
                if (nopins == 1 && toInt == 2){
                    UserInterface.printMessage("Det finns bara en kvar");
                    break;
                }
                break;
            }
            else{
                UserInterface.printMessage("Dålig input skriv 1 eller 2");
            }

        }
        return toInt;


    }
}
