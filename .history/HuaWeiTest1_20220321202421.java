import java.util.Scanner;

public class HuaWeiTest1 {
    public static void main(String[] args) {
        int k;// 队列长度k
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        // k个节点转发能力数组，转发能力m，缓存能力n
        MN[] mn = new MN[k];
        for (int i = 0; i < k; i++) {
            String[] strs = sc.next().split(",");
            mn[i] = new MN(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        }
        // 数据包个数
        int a = sc.nextInt();
        // dp[i]表示经过第i个节点最少发出的包个数
        int[] dp = new int[k + 1];
        dp[0] = a;// 0个节点是多少就多少
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            // 经过该节点后的数据包
            int countData = countData(mn[i], dp[i - 1]);

            // 两种情况当前节点跳过和不跳过

            // 前一个节点故障，当前节点必须上
            if (mn[i - 1].getIsBad() == true) {
                dp[i] = countData;
            } else {
                // 前一个节点没故障，当前跳不跳过都行
                dp[i] = Math.min(countData, dp[i - 1]);
                //等于前一个说明跳过了
                if (dp[i] == dp[i - 1])
                    mn[i].setBad(true);

            }

        }

        sc.close();
    }

    /**
     * 计算经过该节点后的数据包
     *
     * @param mn      节点
     * @param receive 接收数据包
     * @return
     */
    public static int countData(MN mn, int receive) {
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
