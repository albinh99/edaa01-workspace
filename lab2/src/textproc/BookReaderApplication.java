package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {

    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("/Users/albinhansson/Documents/edaa01-workspace/lab2/nilsholg.txt"));
        Scanner scan = new Scanner(new File("/Users/albinhansson/Documents/edaa01-workspace/lab2/undantagsord.txt"));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

        Set<String> stopwords = new HashSet<>();

        while (scan.hasNext()){
            String stop = scan.next().toLowerCase();
            stopwords.add(stop);
        }

        TextProcessor stop = new GeneralWordCounter(stopwords);
        GeneralWordCounter gwc = new GeneralWordCounter(stopwords);


        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            stop.process(word);
            gwc.process(word);

        }

        s.close();
        //stop.report();
        BookReaderController controller = new BookReaderController(gwc);

    }
}
