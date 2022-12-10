package sudoku;

public class SudokuClass implements SudokuSolver {

    public int[][] matris;


    public SudokuClass(){
        this.matris = new int[9][9];
    }

    @Override
    public boolean solve() {
        return solver(0,0,1);
    }

    private boolean solver(int row, int col, int digit){

        if (digit>9){
            return false;
        }
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (possible(i, j, digit)) {
                    add(i, j, digit);
                } else {
                    solver(i, j, digit +1);
                }
                }
            }
        return false;
    }

    private boolean possible (int row, int col, int val){

        for (int i = 0; i < 9; i++){
            if (val == matris[row][i] || val == matris[i][col]){
                return false;
            }
        }
        return subgridcheck(row,col,val);
    }

    private boolean subgridcheck(int row, int col, int val){
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        for (int rowindex = 0; rowindex < 3; rowindex ++){
            for (int colindex = 0; colindex < 3; colindex ++){
                int rowtocheck = rowStart + rowindex;
                int coltocheck = colStart + colindex;
                if (val == matris[rowtocheck][coltocheck]){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void add(int row, int col, int digit) {
        matris[row][col] = digit;
    }

    @Override
    public void remove(int row, int col) {
        matris[row][col] = 0;
    }

    @Override
    public int get(int row, int col) {
        return matris[row][col];
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void setMatrix(int[][] m){
        if (m.length == 9 && m[0].length == 9){
            matris = m;
        }
    }

    @Override
    public int[][] getMatrix() {
        return new int[0][];
    }
}
