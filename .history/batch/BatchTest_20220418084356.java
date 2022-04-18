package batch;

import java.util.HashMap;

public class BatchTest {
    public static void main(String[] args) {
        var hashMap = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                hashMap.put(i, (i * i));
            else
                hashMap.put(i, String.valueOf(i * i));

        }
        hashMap.forEach((k, v) -> System.out.println(k + "->" + v));

    }
}
