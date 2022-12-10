package lpt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class bull {
    public static void main(String[] args) {
        Map<String, Integer> apa = new HashMap<>();
        apa.put("akka", 2);
        apa.put("hej",10);
        apa.put("glass",15);
        apa.entrySet().stream().forEach(System.out::println);
        List<Map.Entry<String,Integer>> l = apa.entrySet().stream().toList();
        System.out.println(l);
    }
}
