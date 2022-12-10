package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Gui extends JFrame{


    public Gui(SudokuClass sudoku) {
        SwingUtilities.invokeLater(() -> createWindow(sudoku, "Sudoku", 600, 600));
    }

    private void createWindow(SudokuClass sudoku, String title,
                              int width, int height) {

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Container pane = frame.getContentPane();


        JPanel board = new JPanel(new GridLayout(9,9));
        add(board);

        JTextField[][] squares =  new JTextField[9][9];

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        for (int row = 0; row < 9; row ++ ){
            for (int col = 0; col < 9; col ++){
                squares[row][col] = new JTextField();
                board.add(squares[row][col]);
            }
        }

        JPanel menu = new JPanel();
        menu.add(new JButton("Clear"));
        menu.add(new JButton("Solve"));
        add(menu);


        frame.pack();
        frame.setVisible(true);


    }
}

