package sudoku;

public class SudokuClass implements SudokuSolver {

    private final int[][] emptymatris;


    public SudokuClass(){
        this.emptymatris = new int[9][9];
    }

    @Override
    public boolean solve() {
        return false;
    }

    @Override
    public void add(int row, int col, int digit) {

    }

    @Override
    public void remove(int row, int col) {

    }

    @Override
    public int get(int row, int col) {
        return 0;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void setMatrix(int[][] m) {


    }

    @Override
    public int[][] getMatrix() {
        return new int[0][];
    }
}
