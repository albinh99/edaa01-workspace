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
        SwingUtilities.invokeLater(() -> createWindow(sudoku, "Sudoku", 800, 800));
    }

    private void createWindow(SudokuClass sudoku, String title, int width, int height) {

        JFrame frame = new JFrame(title);
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);
        JPanel grid = new JPanel(new GridLayout(9, 9, 2,2));
        grid.setSize(height,width);

        Font font1 = new Font("SansSerif", Font.BOLD, 40);


        for (int i = 0; i < 81; ++i) {
            JTextField field = new JTextField(2);
            field.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
            field.setBorder(fieldBorder); //Add the colored border.
            field.setFont(font1);
            //field.setBackground(Color.red);
            grid.add(field);

        }

        final JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);


        frame.getContentPane().add(centeredGrid);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);



    }
}

