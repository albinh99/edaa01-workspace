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

        JButton alpha = new JButton("Alphabetic");
            southPanel.add(alpha);
            alpha.addActionListener(e -> {
                listModel.sort(Map.Entry.comparingByKey());
                    });

        JButton freq = new JButton("Frequency");
            southPanel.add(freq);
            freq.addActionListener(e -> {
                listModel.sort(Map.Entry.comparingByValue());
            });
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300,25));
            southPanel.add(textField);


        JButton find = new JButton("Find");
            southPanel.add(find);
            find.addActionListener(e -> {
                for (int i = 0;  i < listModel.getSize(); i ++){
                    System.out.println(listModel.getSize());
                    if(listModel.getElementAt(i).equals(textField.getText())){
                        System.out.println("hhhhhhh");
                        jlista.ensureIndexIsVisible(i);
                    }

                }
        });


        pane.add(southPanel, BorderLayout.SOUTH);



        JScrollPane scrollPane = new JScrollPane(jlista);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setBorder(new EmptyBorder(5,10,5,10));

        pane.add(scrollPane, BorderLayout.CENTER);




        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        frame.pack();
        frame.setVisible(true);
    }
}
