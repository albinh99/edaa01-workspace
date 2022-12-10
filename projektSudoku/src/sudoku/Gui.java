package sudoku;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Gui {


    public Gui() {
        SwingUtilities.invokeLater(() -> createWindow( "Sudoku", 100, 300));
    }

    private void createWindow( String title,
                              int width, int height) {

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();


        JPanel southPanel = new JPanel();

        JRadioButton alpha = new JRadioButton("Solve");
        JRadioButton freq = new JRadioButton("Clear");
        ButtonGroup group = new ButtonGroup();
        JTextField textField = new JTextField();

        group.add(alpha);
        group.add(freq);
        southPanel.add(alpha);
        southPanel.add(freq);
        southPanel.add(textField);
        southPanel.add(find);
        pane.add(southPanel, BorderLayout.SOUTH);



        frame.pack();
        frame.setVisible(true);


    }
}

