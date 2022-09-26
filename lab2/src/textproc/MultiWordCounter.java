package textproc;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MultiWordCounter implements TextProcessor {
    Map <String, Integer> map = new HashMap <String, Integer>();
    public MultiWordCounter (String[] landskap){
        for(String a : landskap){
            map.put(a,0);
        }
    }
    @Override
    public void process(String w) {
        for(var entry : map.entrySet()){
            if (Objects.equals(w, entry.getKey())) {
                map.put(entry.getKey(), entry.getValue()+1);
            }
        }

    }

    @Override
    public void report() {
        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));

        }

    }
}
