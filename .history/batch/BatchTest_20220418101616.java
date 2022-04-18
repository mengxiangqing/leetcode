package batch;

import java.util.concurrent.ConcurrentHashMap;

public class BatchTest {
    public static void main(String[] args) {
        var map = new ConcurrentHashMap<Integer,Integer>();
        for (int i = 100000; i < 101000; i++) {
            map.put(i, i * i);

        }
       System.out.println(map.search(1, (k, v) -> v > 1000 ? k : null));
        map.forEach(1, (k,v)->k+"->"+v,System.out::println);
        map.forEach((k,v)->System.out.println(k+"->>>"+v));
    }
}
