package textproc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }


    private void createWindow(GeneralWordCounter counter, String title,
                              int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(counter.getWordList());
        JList<Map.Entry<String, Integer>> jlista = new JList<>(listModel);

        jlista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        JPanel southPanel = new JPanel();

        JRadioButton alpha = new JRadioButton("Alphabetic");
        JRadioButton freq = new JRadioButton("Frequency");
        ButtonGroup group = new ButtonGroup();
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300,25));
        JButton find = new JButton("Find");
        group.add(alpha);
        group.add(freq);
        southPanel.add(alpha);
        southPanel.add(freq);
        southPanel.add(textField);
        southPanel.add(find);
        pane.add(southPanel, BorderLayout.SOUTH);

        alpha.addActionListener(e -> {
            listModel.sort(Map.Entry.comparingByKey());
        });

        freq.addActionListener(e -> {
            listModel.sort((e1, e2) -> e2.getValue() - e1.getValue());
        });

        find.addActionListener(e -> {
            boolean wordNotInList = true;
            for (int i = 0;  i < listModel.getSize(); i ++){

                if(listModel.getElementAt(i).getKey().equals(textField.getText())){
                    jlista.ensureIndexIsVisible(i);
                    jlista.setSelectedIndex(i);
                    wordNotInList = false;
                }
                else if (i == listModel.getSize()-1 && wordNotInList){
                    JOptionPane.showMessageDialog(null, "Ordet finns inte");
                }

            }
        });
        frame.getRootPane().setDefaultButton(find); // söker på enter



        JScrollPane scrollPane = new JScrollPane(jlista);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setBorder(new EmptyBorder(5,10,5,10));

        pane.add(scrollPane, BorderLayout.CENTER);


        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        frame.pack();
        frame.setVisible(true);
    }
}