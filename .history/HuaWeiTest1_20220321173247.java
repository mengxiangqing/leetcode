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
        // dp[i]表示i个节点最少收到的包个数
        int[] dp = new int[k + 1];
        dp[0] = 0;

        sc.close();
    }

    public static int countData(MN mn,int receive) {
        int count = 0;
        return count;

    }
}

/**
 * MN
 */
class MN {
    int m;

    int n;
    boolean isBad;

    public MN(int m, int n) {
        this.m = m;
        this.n = n;
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
