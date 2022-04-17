package sieve;

import java.util.BitSet;

/**
 * 埃拉托色尼筛选法，查找素数
 */
public class Sieve {
    public static void main(String[] args) {
        int n = (int) 2e6;
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            bitSet.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (bitSet.get(i)) {
                count++;
                int k = 2 * i;

                while (k <= n) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (bitSet.get(i))
                count++;
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count+" primes");
        System.out.println((end-start)+" milliseconds");
    }
}