import java.util.Scanner;

public class HuaWeiTest1 {
    public static void main(String[] args) {
        int k;// 队列长度k
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        // k个节点转发能力数组，转发能力m，缓存能力n
        MN[] mn = new MN[k + 1];
        for (int i = 1; i <= k; i++) {
            String[] strs = sc.next().split(",");
            mn[i] = new MN(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        }
        mn[0] = new MN();
        // 数据包个数
        int a = sc.nextInt();
        int minData = Integer.MAX_VALUE;
        int countOne;
        int countTwo;
        for (int i = 1; i < k + 1; i++) {
            // 如果上一个节点没故障，尝试一下当前节点故障最后什么结果
            int sum2 = Integer.MAX_VALUE;
            if (mn[i - 1].isBad == false) {
                mn[i].setBad(true);
                countOne = countOneOrTwo(mn, a, k);
                countTwo = countOneOrTwo(mn, 0, k);
                sum2 = countOne + countTwo;
                minData = Math.min(minData, sum2);

            }
            // 当前节点未故障
            countOne = countOneOrTwo(mn, a, k);
            countTwo = countOneOrTwo(mn, 0, k);
            int sum1 = countOne + countTwo;
            if (sum2 > sum1) {
                mn[i].setBad(false);
            }
            minData = Math.min(minData, sum1);

        }
        System.out.println(minData);
        sc.close();

    }

    public static int countOneOrTwo(MN[] mn, int initReceive, int len) {
        // 第二轮，直接传缓存的，故障的继续故障
        int dp2[] = new int[len + 1];
        dp2[0] = initReceive;
        for (int i = 1; i < dp2.length; i++) {
            // 经过该节点后的数据包
            dp2[i] = countData(mn[i], dp2[i - 1]);

        }
        return dp2[len];
    }

    /**
     * 计算经过该节点后的数据包
     *
     * @param mn      节点
     * @param receive 接收数据包
     * @return
     */
    public static int countData(MN mn, int receive) {
        if (mn.isBad)
            return receive;
        int count = 0;
        int cache = mn.getCache();
        // 在该节点的数据包总数
        int sum = cache + receive;
        // 比转发能力大
        if (sum > mn.m) {
            count = mn.m;
            // 剩余数据包比缓存能力大
            if (sum - mn.m > mn.n) {
                mn.setCache(mn.n);
            } else
                mn.setCache(sum - mn.m);
        } else {
            count = sum;
            mn.setCache(0);
        }
        return count;
    }
}

/**
 * MN
 */
class MN {
    int m; // 转发能力
    int n; // 缓存能力
    int cache; // 现有缓存
    boolean isBad;

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public MN(int m, int n) {
        this.m = m;
        this.n = n;
        this.cache = 0;
    }

    public MN() {
    }

    public void setBad(boolean isBad) {
        this.isBad = isBad;
    }

    public boolean getIsBad() {
        return this.isBad;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}

class 污染水域 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numStr = sc.nextLine().split(",");
        sc.close();
        int n = (int) Math.sqrt(numStr.length);
        int[][] num = new int[n][n];
        int k = 0;
        boolean flag = false;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                num[i][j] = Integer.parseInt(numStr[k++]);
                if (num[i][j] == 1)
                    flag = true;
            }
        }
        if (!flag)
            System.out.println(-1);

    }
}