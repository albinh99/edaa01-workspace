package Game;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class UserInterface {
    public static void printMessage(String msg){


    }

    public static int askForInt(String msg){
        int toInt;
        while(true){

            msg = showInputDialog("Ta en eller två pinnar");
            if(msg.equals("1")||msg.equals("2")){
                toInt = Integer.parseInt(msg);
                break;
            }
            else{
                showMessageDialog(null, "Ta en eller två pinnar");
            }

        }
        return toInt;


    }
}
