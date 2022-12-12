package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class SudokuGUI extends JFrame{

    private SudokuSolver sudoku; //attribut
    private JTextField [][] guiMatrix = new JTextField[9][9]; // Textfield-matris som sparar värdena från användarens input

    public SudokuGUI(SudokuSolver sudoku) { //konstruktor
        SwingUtilities.invokeLater(() -> createWindow(sudoku)); // vid instansiering av sudokugui öppnas ett fönster
        this.sudoku = sudoku;
    }

    private void createWindow(SudokuSolver sudoku) { //fönsterklass


        JFrame frame = new JFrame("Sudoku"); // ram till fönstret
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane(); // panel som smalar det vi


        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK); //gränsen mellan rutorna
        JPanel grid = new JPanel(new GridLayout(9, 9, 2,2)); // Panel som är ett 9x9 rutnät
        Font font1 = new Font("SansSerif", Font.BOLD, 40); // font sätts för att rutorna och texten ska få rätt storlek

        //Lägger till en panel underst i fönstret för knapparna
        JPanel southPanel = new JPanel();
        JButton solveButton = new JButton("Solve");
        JButton clearButton = new JButton("Clear");
        southPanel.add(solveButton);
        southPanel.add(clearButton);
        pane.add(southPanel, BorderLayout.SOUTH);

        // Skapar 81 textfield rutor som sparas i guiMatris attributet
        for (int i = 0; i<9; i++){
            for (int j = 0; j < 9; j++){
                JTextField boxes = new JTextField(2);
                boxes.setHorizontalAlignment(JTextField.CENTER); //Ser till så texten är centrerad i textfielden
                boxes.setBorder(fieldBorder);
                boxes.setFont(font1);
                guiMatrix[i][j] = boxes;
                setColor(i,j, guiMatrix[i][j]);
                boxes.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) { // Ser till så man bara kan skriva in siffror 1-9 och inget annat
                        if (boxes.getText().length() >= 1 || e.getKeyChar()>'9' || e.getKeyChar()<'1'){ // limit text-field to 3 characters
                            e.consume();
                            if (e.getKeyChar()!= KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_ENTER){
                            JOptionPane.showMessageDialog(null, "Endast siffror 1-9 godtas");
                            }
                        }
                    }});
                grid.add(boxes); // Lägger till textfieldsen i grid-panelen
            }
        }






        solveButton.addActionListener(e -> { //knapp för solve
            buildFirstMatrix();

            if(!sudoku.isValid()){
                JOptionPane.showMessageDialog(null, "Inskrivna värden följer ej sudokureglerna");
            }
            else if (sudoku.isValid() && sudoku.solve()){
                buildFinalMatrix();
            }
            else {
                JOptionPane.showMessageDialog(null, "Sudokut går inte att lösa");
            }
        });


        clearButton.addActionListener(e-> clearMatrix());


        //Sammanställer fönstret
        JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);
        frame.getContentPane().add(centeredGrid);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }


    private void buildFirstMatrix(){ //Bygger sudoku matris som Sudokuclass kan lösa
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
    private void buildFinalMatrix() { //Bygger det lösta sudokut
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                guiMatrix[i][j].setText( String.valueOf(sudoku.get(i, j)));

            }
        }
        JOptionPane.showMessageDialog(null, "Sudokut är löst");

    }
    private void clearMatrix(){ //Tömmer sudokubrädet
        sudoku.clear();
        for (int i = 0; i<9; i++){
            for (int j = 0; j <9; j++){
                guiMatrix[i][j].setText("");
            }
    }

}
    private void setColor(int row, int col,JTextField tField){ //Delar in regionerna i en annan färg
        if ((row/3 + col/3 )%2 ==0){
        tField.setBackground(Color.orange);
    }}
}

