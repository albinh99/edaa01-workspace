package sudoku;

public class SudokuMain {
    public static void main(String[] args) {

        SudokuSolverClass sudoku = new SudokuSolverClass();
        sudoku.add(0,0,1);
        sudoku.add(8,0,1);
        //sudoku.add(2,8,5);
        //sudoku.add(3,6,1);
        //sudoku.add(7,7,1);
        //System.out.println(sudoku.solve());



        SudokuGUI g = new SudokuGUI(sudoku);
        //System.out.println(sudoku.isValid());
        //System.out.println(Arrays.deepToString(sudoku.matris));
       // for (int i = 0; i<9; i++){
         //  System.out.println((Arrays.toString(sudoku.matris[i])));
        //}




    }
}
