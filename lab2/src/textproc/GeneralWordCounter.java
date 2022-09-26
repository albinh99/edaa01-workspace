package textproc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor{

    Map<String, Integer> mapGWC = new HashMap<String, Integer>();
    Set <String> stopwords;


    public GeneralWordCounter (Set<String> stopwords){
        this.stopwords = stopwords;
    }
    @Override
    public void process(String w) {
        if(w != stopwords)

    }

    @Override
    public void report() {

    }
}
