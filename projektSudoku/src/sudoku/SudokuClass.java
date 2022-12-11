package sudoku;


public class SudokuClass implements SudokuSolver {

    public int[][] sudokuGrid;


    public SudokuClass() {
        this.sudokuGrid = new int[9][9];
    }

    @Override
    public boolean solve() { //metod som försöker lösa sudokut
        if (isValid()) { //börjar med att kolla om griden är möjlig att lösa då...
            for (int row = 0; row < 9; row++) { //...användaren satt in en siffra och utgår från kraven. Om true körs loopen nedan
                for (int col = 0; col < 9; col++) {

                    if (sudokuGrid[row][col] == 0) { //kollar om cellen är tom, dvs har värdet 0 (har ej ändrats av användaren)
                        for (int k = 1; k <= 9; k++) { //loopar igenom 1-9
                            if (possible(row, col, k)) { //testar om siffran fungerar att sätta in utifrån kraven
                                add(row, col, k); //lägger in värdet i såna fall

                                if (solve()) { //backtracking
                                    return true;
                                } else {
                                    sudokuGrid[row][col] = 0; //om det inte finns en lösning sätter vi cellen till 0 och fortsätter
                                }
                            }
                        }
                        return false;
                    }


                }
            }
            return true; //sudokut är löst
        }
        else {
            return false; //om isValid inte är true returneras false
        }

    }
    private boolean possible(int row, int col, int val) { //kollar sudokuts regler

        for (int i = 0; i < 9; i++) {
            if (val == sudokuGrid[row][i] || val == sudokuGrid[i][col]) { //returnar false om samma siffra är på samma row/col
                return false;
            }
        }
        return subgridcheck(row, col, val); //returnerar false om samma siffra är i samma region
    }

    private boolean subgridcheck(int row, int col, int val) {
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int rowindex = 0; rowindex < 3; rowindex++) {
            for (int colindex = 0; colindex < 3; colindex++) {
                int rowtocheck = rowStart + rowindex;
                int coltocheck = colStart + colindex;
                if (val == sudokuGrid[rowtocheck][coltocheck]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void add(int row, int col, int digit) { //lägger till en siffra på row, col
        sudokuGrid[row][col] = digit;
    }

    @Override
    public void remove(int row, int col) { //sätter siffran på row,col till 0
        sudokuGrid[row][col] = 0;
    }

    @Override
    public int get(int row, int col) { //hämtar siffran på row,col
        return sudokuGrid[row][col];
    }

    @Override
    public boolean isValid() { //kollar så inmatade spelbrädet följer reglarna
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(sudokuGrid[row][col] != 0){
                    int temp = sudokuGrid[row][col]; //sparar värdet och sätter till noll för att possible ska kunna användas
                    sudokuGrid[row][col] = 0;
                    if(possible(row, col, temp)){
                        sudokuGrid[row][col] = temp; //om det är ok behåller vi siffran på platsen
                    }else {
                        return false; //om siffran inte uppfyller reglerna returneras false
                    }
                }
            }
        }
        return true; //inmatade spelbrädet följer reglerna
    }

    @Override
    public void clear() { //sätter alla rutor på spelbrädet till noll.
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++) {
                sudokuGrid[row][col] = 0;
            }
        }

    }


    @Override
    public void setMatrix(int[][] m) { //ansätter en färdig matris till spelbrädet direkt om det följer reglerna för...
        if(m.length != 9 || m[0].length!=9){ //...storlek och tal mellan 1 och 9.
            throw new IllegalArgumentException();
        }
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (m[i][j]<0 || m[i][j] > 9){
                    throw new IllegalArgumentException();
                }
            }
        }
        sudokuGrid = m.clone();
    }

    @Override
    public int[][] getMatrix() { //hämtar en kopia av spelbrädet
        return sudokuGrid.clone();
    }
}
