package textproc;

import java.util.*;
import java.util.stream.Collectors;

public class GeneralWordCounter implements TextProcessor{
    Map<String, Integer> mapGWC = new TreeMap<String, Integer>();
    Set <String> stopwords;


    public GeneralWordCounter (Set<String> stopwords){
        this.stopwords = stopwords;
    }

    @Override
    public void process(String w) {
        if(!stopwords.contains(w)){
            if(!mapGWC.containsKey(w)){
                mapGWC.put(w,1);
            }
            else{
                mapGWC.put(w, mapGWC.get(w)+1);
            }
        }

    }

    @Override
    public void report() {
        /*
        for(String key : mapGWC.keySet()) {
            if (mapGWC.get(key) >= 200) {
                System.out.println(key + ": " + mapGWC.get(key)); */

        Set<Map.Entry<String,Integer>> wordSet = mapGWC.entrySet();
        List<Map.Entry<String,Integer>> wordList = new ArrayList<>(wordSet);
        wordList.sort((w1,w2) -> {
            int valueSorted = w2.getValue()-w1.getValue();
            if (valueSorted == 0){
                return w1.getKey().compareTo(w2.getKey());
            }
            else{
                return valueSorted;
            }
        });

        //System.out.println(wordSet);
        for(int i = 0; i < 50; i++){
        System.out.println(wordList.get(i));
            }
        }
    public List<Map.Entry<String, Integer>> getWordList() {

        return mapGWC.entrySet().stream().toList();
    }


        }

