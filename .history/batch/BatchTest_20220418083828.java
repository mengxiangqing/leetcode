package batch;

import java.util.HashMap;
import java.util.Map.Entry;

public class BatchTest {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, String>();
        for (int i = 1; i <= 100; i++) {
            hashMap.put(i, String.valueOf(i * i));
        }
        hashMap.forEach((k, v) -> System.out.println(k + "->" + v));
        var iter = hashMap.entrySet();
        for (Entry<Integer,String> entry : iter) {
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }
}
