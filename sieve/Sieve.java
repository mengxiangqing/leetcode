package sieve;

import java.util.BitSet;

/**
 * 埃拉托色尼筛选法，查找素数
 * 挨个去除最小数的倍数，比如2的倍数，3的倍数，5的倍数等等
 */
public class Sieve {
    public static void main(String[] args) {
        int n = (int) 2e2;
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            bitSet.set(i);
        }
        i = 2;
        // 思考为什么是到这个数后面的数就都确定了,在往上加的话,相对于i的另一个数就是比i小的数,计算重复
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
        System.out.println(bitSet.toString());
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
