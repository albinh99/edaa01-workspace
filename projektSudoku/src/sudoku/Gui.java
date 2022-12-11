package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class Gui extends JFrame{

    SudokuSolver sudoku;
    JTextField [][] matrisgui = new JTextField[9][9];

    public Gui(SudokuSolver sudoku) {
        SwingUtilities.invokeLater(() -> createWindow(sudoku, "Sudoku", 800, 800));
        this.sudoku = sudoku;
    }

    private void createWindow(SudokuSolver sudoku, String title, int width, int height) {


        JFrame frame = new JFrame(title);
        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();


        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);
        JPanel grid = new JPanel(new GridLayout(9, 9, 2,2));
        grid.setSize(height,width);

        Font font1 = new Font("SansSerif", Font.BOLD, 40);

        JPanel southPanel = new JPanel();

        JButton solveButton = new JButton("Solve");
        JButton clearButton = new JButton("Clear");

        southPanel.add(solveButton);
        southPanel.add(clearButton);
        pane.add(southPanel, BorderLayout.SOUTH);


        JTextField [][] field = new JTextField[9][9];


        for (int i = 0; i<9; i++){
            for (int j = 0; j < 9; j++){
                JTextField field1 = new JTextField(2);
                field1.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
                field1.setBorder(fieldBorder); //Add the colored border.
                field1.setFont(font1);
                matrisgui[i][j] = field1;
                setColor(i,j,matrisgui[i][j]);
                field1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (field1.getText().length() >= 1 || e.getKeyChar()>'9' || e.getKeyChar()<'1') // limit textfield to 3 characters
                            e.consume();
                    }});
                grid.add(field1);
            }
        }

        solveButton.addActionListener(e -> {
            buildFirstMatrix();
            if (sudoku.isValid()){
                sudoku.solve();
                buildFinalMatrix();
            }
            else {
                JOptionPane.showMessageDialog(null, "negatove");
            }
        });



        clearButton.addActionListener(e-> {
            clearMatrix();
        });


        final JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);
        frame.getContentPane().add(centeredGrid);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);


        //solveButton.addActionListener(e-> System.out.println(grid.getComponentAt(0,0)));
    }

    private void buildFinalMatrix() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrisgui[i][j].setText( String.valueOf(sudoku.get(i, j)));
            }
        }
    }
    private void buildFirstMatrix(){
        for (int i = 0; i<9; i++){
            for (int j = 0; j <9; j++){
                if (Objects.equals(matrisgui[i][j].getText(), "")) {
                    sudoku.add(i,j,0);
                }else {
                sudoku.add(i,j,Integer.parseInt(matrisgui[i][j].getText()));
            }
        }
    }
}
    private void clearMatrix(){
        sudoku.clear();
        for (int i = 0; i<9; i++){
            for (int j = 0; j <9; j++){
                matrisgui[i][j].setText("");
            }
    }

}
    private void setColor(int row, int col,JTextField tField){
        if ((row/3 + col/3 )%2 ==0){
        tField.setBackground(Color.orange);
    }}
}

