package batch;

import java.util.HashMap;
import java.util.Map.Entry;

public class BatchTest {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 100; i++) {
            hashMap.put(i, (i * i));
        }
        hashMap.forEach((k, v) -> System.out.println(k + "->" + v));
        var entrySet = hashMap.entrySet();
        var keySet = hashMap.keySet();

    }
}
