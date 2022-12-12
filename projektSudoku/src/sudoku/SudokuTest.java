package sudoku;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuTest {


    private SudokuSolverClass sudoku;

    @BeforeEach
    void setUp(){
        sudoku = new SudokuSolverClass();
    }

    @AfterEach
    void tearDown(){
        sudoku = null;
    }

    @Test
    void TryEmptySudoku(){
        assertTrue(sudoku.solve());

    }
    @Test
    void SolveFigure1(){
        sudoku.add(0,2,8);
        sudoku.add(0,5,9);
        sudoku.add(0,8,2);
        sudoku.add(2,0,1);
        sudoku.add(2,2,2);
        sudoku.add(2,3,5);
        sudoku.add(1,8,5);
        sudoku.add(4,1,5);
        sudoku.add(3,3,2);
        sudoku.add(3,4,1);
        sudoku.add(4,7,9);
        sudoku.add(4,6,6);
        sudoku.add(5,7,2);
        sudoku.add(5,8,8);
        sudoku.add(6,0,4);
        sudoku.add(6,1,1);
        sudoku.add(7,0,8);
        sudoku.add(7,1,6);
        sudoku.add(6,3,6);
        sudoku.add(7,4,3);
        sudoku.add(6,5,8);
        sudoku.add(7,6,1);
        sudoku.add(8,6,4);
        assertTrue(sudoku.solve());
        assertTrue(sudoku.isValid());
    }
    @Test
    void UnsolvableCases(){
        sudoku.add(0,0,1);
        sudoku.add(8,0,1);
        assertFalse(sudoku.solve());
        sudoku.clear();
        sudoku.add(8,5,1);
        sudoku.add(8,0,1);
        assertFalse(sudoku.solve());
        sudoku.clear();
        sudoku.add(8,8,1);
        sudoku.add(6,6,1);
        assertFalse(sudoku.solve());
    }
    @Test
    void UsolvableSudoku(){
        sudoku.add(0,0,1);
        sudoku.add(0,1,2);
        sudoku.add(0,2,3);
        sudoku.add(1,0,4);
        sudoku.add(1,1,5);
        sudoku.add(1,2,6);
        sudoku.add(2,3,7);
        assertFalse(sudoku.solve());
        sudoku.remove(2,3);
        assertTrue(sudoku.solve());

    }

    @Test
    void add(){
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(4,10,4));
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(10,4,4));
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(4,4,10));
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(4,4,-12));
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(4,-4,4));
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(-4,4,1));
        assertThrows(IllegalArgumentException.class,() -> sudoku.add(14,14,10));

        sudoku.add(1,2,6);
        assertEquals(6,sudoku.get(1,2));
    }

    @Test
    void GetValue(){
        sudoku.add(1,2,6);
        assertEquals(6,sudoku.get(1,2));
    }
    @Test
    void Clear(){
        sudoku.add(1,8,5);
        sudoku.add(4,1,5);
        sudoku.add(3,3,2);
        sudoku.add(3,4,1);
        sudoku.add(4,7,9);
        sudoku.add(4,6,6);
        sudoku.add(5,7,2);
        sudoku.add(5,8,8);
        sudoku.clear();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                assertEquals(0,sudoku.get(i,j));
            }
        }

    }


}
