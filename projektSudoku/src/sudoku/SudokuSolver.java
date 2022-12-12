package sudoku;

public interface SudokuSolver {
    /**
     * Tries to solve the sudoku
     * Returns true if solution is found, false otherwise
     */
    boolean solve();

    /**
     * Puts digit in the box row, col.
     *
     * @param row   The row
     * @param col   The column
     * @param digit The digit to insert in box row, col
     * @throws IllegalArgumentException if row, col or digit is outside the range
     *                                  [0..9]
     */
    void add(int row, int col, int digit);

    /**
     * Removes the digit on the corresponding grid coordinates, (row, col).
     * @param row   The row
     * @param col   The column
     */
    void remove(int row, int col);

    /**
     * Returns the digit on the corresponding grid coordinates, (row, col).
     * @param row   The row
     * @param col   The column
     */
    int get(int row, int col);

    /**
     * Checks that all filled in digits follows the sudoku rules.
     */
    boolean isValid();

    /**
     * Clears all values from the sudoku board by setting them to zero
     */
    void clear();

    /**
     * Fills the grid with the digits in m. The digit 0 represents an empty box.
     *
     * @param m the matrix with the digits to insert
     * @throws IllegalArgumentException if m has the wrong dimension or contains
     *                                  values outside the range [0..9]
     */
    void setMatrix(int[][] m);

    /**
     * Returns the sudoku board with empty values represented by zeros.
     */
    int[][] getMatrix();
}