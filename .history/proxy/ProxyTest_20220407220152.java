package proxy;

public class ProxyTest {
    public static void main(String[] args) {
        var elements = new Object[100];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);

        }
    }
}
