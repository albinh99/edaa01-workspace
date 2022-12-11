package sudoku;

import javax.swing.*;
import java.util.Arrays;

public class Huvud {
    public static void main(String[] args) {
        SudokuClass sudoku = new SudokuClass();
        sudoku.add(2,4,1);
        sudoku.add(3,3,1);
        //sudoku.add(2,8,5);
        //sudoku.add(3,6,1);
        //sudoku.add(7,7,1);
        sudoku.solve();



        Gui g = new Gui(sudoku);
        //System.out.println(sudoku.isValid());
        //System.out.println(Arrays.deepToString(sudoku.matris));
       // for (int i = 0; i<9; i++){
         //  System.out.println((Arrays.toString(sudoku.matris[i])));
        //}








    }
}
