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

		TextProcessor r = new MultiWordCounter(REGIONS);
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor n = new SingleWordCounter("norge");
		//TextProcessor stop = new SingleWordCounter("stopwords");

		ArrayList<TextProcessor> allt = new ArrayList<>(Arrays.asList(r,p,n));


		Scanner s = new Scanner(new File("/Users/albinhansson/Documents/edaa01-workspace/lab2/nilsholg.txt"));
		Scanner scan = new Scanner(new File("/Users/albinhansson/Documents/edaa01-workspace/lab2/undantagsord.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning


		while (scan.hasNext()){
			stopwords.add(scan.next().toLowerCase());

		}

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			r.process(word);
			p.process(word);
			n.process(word);
		}

		s.close();


		r.report();
		p.report();
		n.report();


	}
}