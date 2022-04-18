package batch;

public class BatchTest {
    public static void main(String[] args) {
        var hashMap = new Map<Integer, String>();
        for (int i = 1; i <= 100; i++) {
            hashMap.put(i, String.valueOf(i * i));
        }
        hashMap.forEach((k, v) -> System.out.println(k + "->" + v));

    }
}
