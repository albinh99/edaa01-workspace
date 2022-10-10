package textproc;

import javax.swing.*;
import java.awt.*;
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

        JList<Map.Entry<String, Integer>> jlista = new JList<>(new SortedListModel(counter.getWordList()));
        SortedListModel<Map.Entry<String,Integer>> listModel = new SortedListModel<>();
        listModel.addListDataListener();

        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        frame.pack();
        frame.setVisible(true);
    }
}
