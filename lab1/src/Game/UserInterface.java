package Game;

import static javax.swing.JOptionPane.*;

public class UserInterface {
    public static void printMessage(String msg){
        showMessageDialog(null,msg);

    }

    public static int askForInt(String msg) {
        int toInt;
        String inputMsg;

        while(true){
            inputMsg = showInputDialog(msg);
            if (inputMsg == null){
                return -2;
            }
            else if(inputMsg.equals("1")||inputMsg.equals("2")){
                toInt = Integer.parseInt(inputMsg);
                break;
                }
            else{
                UserInterface.printMessage("Felaktig input, vänligen ta 1 eller 2 pinnar");
            }

        }
        return toInt;


    }
}



