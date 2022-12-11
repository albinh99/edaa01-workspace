package sudoku;

public class SudokuClass implements SudokuSolver {

    public int[][] matris;


    public SudokuClass() {
        this.matris = new int[9][9];
    }

    @Override
    public boolean solve() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (matris[row][col] == 0) { //kollar om cellen är tom, dvs har värdet 0 (har ej ändrats av användaren)
                    for (int k = 1; k <= 9; k++) { //loopar igenom 1-9
                        if (possible(row, col, k)) { //testar om siffran fungerar att sätta in utifrån kraven
                            add(row, col, k); //lägger in värdet

                            if (solve()) { //backtracking
                                return true;
                            } else {
                                matris[row][col] = 0; //om det inte finns en lösning sätter vi cellen till 0 och fortsätter
                                //return false;
                            }
                        }
                    }
                    return false;
                }

            }
        }
        return true; //sudokut är löst
    }

    private boolean possible(int row, int col, int val) {

        for (int i = 0; i < 9; i++) {
            if (val == matris[row][i] || val == matris[i][col]) {
                return false;
            }
        }
        return subgridcheck(row, col, val);
    }

    private boolean subgridcheck(int row, int col, int val) {
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int rowindex = 0; rowindex < 3; rowindex++) {
            for (int colindex = 0; colindex < 3; colindex++) {
                int rowtocheck = rowStart + rowindex;
                int coltocheck = colStart + colindex;
                if (val == matris[rowtocheck][coltocheck]) {
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
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(matris[row][col] != 0){
                    int temp = matris[row][col];
                    matris[row][col] = 0;
                    if(possible(row, col, temp)){
                        matris[row][col] = temp;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++) {
                matris[row][col] = 0;
            }
        }

    }

    @Override
    public void setMatrix(int[][] m) {
        if (m.length == 9 && m[0].length == 9) {
            matris = m;
        }
    }

    @Override
    public int[][] getMatrix() {
        return matris.clone();
    }
}
