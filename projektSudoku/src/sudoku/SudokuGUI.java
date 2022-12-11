package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class SudokuGUI extends JFrame{

    SudokuSolver sudoku;
    JTextField [][] guiMatrix = new JTextField[9][9];

    public SudokuGUI(SudokuSolver sudoku) {
        SwingUtilities.invokeLater(() -> createWindow(sudoku));
        this.sudoku = sudoku;
    }

    private void createWindow(SudokuSolver sudoku) {


        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();


        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);
        JPanel grid = new JPanel(new GridLayout(9, 9, 2,2));
        Font font1 = new Font("SansSerif", Font.BOLD, 40);


        JPanel southPanel = new JPanel();
        JButton solveButton = new JButton("Solve");
        JButton clearButton = new JButton("Clear");
        southPanel.add(solveButton);
        southPanel.add(clearButton);
        pane.add(southPanel, BorderLayout.SOUTH);

        for (int i = 0; i<9; i++){
            for (int j = 0; j < 9; j++){
                JTextField boxes = new JTextField(2);
                boxes.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
                boxes.setBorder(fieldBorder); //Add the colored border.
                boxes.setFont(font1);
                guiMatrix[i][j] = boxes;
                setColor(i,j, guiMatrix[i][j]);
                boxes.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (boxes.getText().length() >= 1 || e.getKeyChar()>'9' || e.getKeyChar()<'1') // limit text-field to 3 characters
                            e.consume();
                    }});
                grid.add(boxes);
            }
        }

        solveButton.addActionListener(e -> { //knapp för solve
            buildFirstMatrix();
            if (sudoku.isValid() && sudoku.solve()){
                buildFinalMatrix();
            }
            else {
                JOptionPane.showMessageDialog(null, "Sudokut går inte att lösa");
            }
        });



        clearButton.addActionListener(e-> clearMatrix());


        final JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);
        frame.getContentPane().add(centeredGrid);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);


        //solveButton.addActionListener(e-> System.out.println(grid.getComponentAt(0,0)));
    }


    private void buildFirstMatrix(){
        for (int i = 0; i<9; i++){
            for (int j = 0; j <9; j++){
                if (Objects.equals(guiMatrix[i][j].getText(), "")) {
                    sudoku.add(i,j,0);
                }else {
                sudoku.add(i,j,Integer.parseInt(guiMatrix[i][j].getText()));
            }
        }
    }
}
    private void buildFinalMatrix() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                guiMatrix[i][j].setText( String.valueOf(sudoku.get(i, j)));

            }
        }
        JOptionPane.showMessageDialog(null, "Sudokut är löst");

    }
    private void clearMatrix(){
        sudoku.clear();
        for (int i = 0; i<9; i++){
            for (int j = 0; j <9; j++){
                guiMatrix[i][j].setText("");
            }
    }

}
    private void setColor(int row, int col,JTextField tField){
        if ((row/3 + col/3 )%2 ==0){
        tField.setBackground(Color.orange);
    }}
}

