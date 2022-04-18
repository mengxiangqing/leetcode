package batch;

import java.util.HashMap;

public class BatchTest {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, String>();
        for (int i = 1; i <= 100; i++) {
            hashMap.put(i, String.valueOf(i * i));
        }
        hashMap.forEach(Long.MAX_VALUE,(k,v)->k+"->"+v,System.out::println);
    }
}
