package textproc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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

        JLabel label = new JLabel("menyrad");
        label.setBorder(new EmptyBorder(5,10,5,10));
        JScrollPane scrollPane = new JScrollPane(jlista);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setBorder(new EmptyBorder(5,10,5,10));

        pane.add(scrollPane, BorderLayout.CENTER);
        pane.add(label, BorderLayout.SOUTH);



        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        frame.pack();
        frame.setVisible(true);
    }
}
