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
        int a = sc.nextInt();
        sc.close();
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

}
