package batch;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class BatchTest {
    public static void main(String[] args) {
        var hashMap = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                hashMap.put(i, (i * i));
            else
                hashMap.put(i, "String" + String.valueOf(i * i));

        }
        hashMap.put("i", "value");
        hashMap.forEach((k, v) -> System.out.println(k + "->" + v));
        var map = new ConcurrentHashMap<Integer,Integer>();
        for (int i = 1; i < 101; i++) {
            map.put(i, i * i);

        }
       System.out.println(map.search(1, (k, v) -> v > 1000 ? v : null));


    }
}
