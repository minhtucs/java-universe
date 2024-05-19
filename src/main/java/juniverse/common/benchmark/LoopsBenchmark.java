package juniverse.common.benchmark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class LoopsBenchmark {

    public static void main(String[] args) {
        LoopsBenchmark benchmark = new LoopsBenchmark();
        benchmark.loop(1_000);
    }
    
    void loop(int size) {
        List<Map<String, Object>> list = generateList(size);
        
        long startMillis = System.currentTimeMillis();
        long startNano = System.nanoTime();
        
//        list.stream().forEach(item -> {});
        List<Map<String, String>> listResult = list.stream().map(this::objectMap2StringMap).collect(Collectors.toList());
//        List<Map<String, Object>> listResult = list.stream().map(e -> e).collect(Collectors.toList());
        
//        List<Map<String, String>> listResult = new ArrayList<>();
//        list.forEach(item -> {
//            Map<String, String> map = objectMap2StringMap(item);
//            listResult.add(map);
//        });
        
        long elapsedNano = System.nanoTime() - startNano;
        long elapsedMillis = System.currentTimeMillis() - startMillis;
        System.err.println("# ELAPSED NANO: " + elapsedNano);
        System.err.println("# ELAPSED MILLIS: " + elapsedMillis);
    }
    
    List<Map<String, Object>> generateList(int size) {
        List<Map<String, Object>> list = new ArrayList();
        for (int i = 0; i < size; i++) {
            Map<String, Object> map = new HashMap();
            map.put("Key", i);
            map.put("Name", "item " + i);
            list.add(map);
        }
        return list;
    }
    
    Map<String, String> objectMap2StringMap(Map<String, Object> map) {
        return map.entrySet().stream().collect(Collectors.toMap(
            e -> e.getKey(), 
            e -> String.valueOf(e.getValue()), 
            (o, n) -> n, 
            HashMap::new));
    }
    
}
