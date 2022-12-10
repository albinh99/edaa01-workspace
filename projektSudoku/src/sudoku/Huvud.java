package sudoku;

import javax.swing.*;
import java.util.Arrays;

public class Huvud {
    public static void main(String[] args) {
        SudokuClass sudoku = new SudokuClass();
        //Gui g = new Gui(sudoku);
        sudoku.solve();
        //System.out.println(Arrays.deepToString(sudoku.matris));
        for (int i = 0; i<9; i++){
            System.out.println((Arrays.toString(sudoku.matris[i])));
        }








    }
}
