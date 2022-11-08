package textproc;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();

		TextProcessor r = new MultiWordCounter(REGIONS);
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor n = new SingleWordCounter("norge");


		Scanner s = new Scanner(new File("/Users/ludvigsjogren/IdeaProjects/edaa01-workspaceGitver2/lab2/nilsholg.txt"));
		Scanner scan = new Scanner(new File("/Users/ludvigsjogren/IdeaProjects/edaa01-workspaceGitver2/lab2/undantagsord.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		Set<String> stopwords = new HashSet<>();


		while (scan.hasNext()){
			String stop = scan.next().toLowerCase();
			stopwords.add(stop);
		}
		TextProcessor stop = new GeneralWordCounter(stopwords);



		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			stop.process(word);
			r.process(word);
			p.process(word);
			n.process(word);
		}

		s.close();

		stop.report();
		//r.report();
		//p.report();
		//n.report();
		//ArrayList<TextProcessor> allt = new ArrayList<>(Arrays.asList(r,p,n,stop));
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);
		BookReaderController brc = new BookReaderController(gwc);
	}
}