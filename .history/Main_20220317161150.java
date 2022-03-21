import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    private static int maxValue;
    private static int minValue;

    public static void main(String[] args) {
        int N, m;
        Scanner in = new Scanner(System.in);
        // 最大预算
        N = in.nextInt();
        // 备选物品件数

        m = in.nextInt();
        // 物品价值
        int[] v = new int[m];
        // 物品重要度
        int[] p = new int[m];
        // 0表示主件，>0表示附件
        int[] q = new int[m];
        minValue = Integer.MIN_VALUE;
        // 输入数组

        for (int i = 0; i < m; i++) {
            v[i] = in.nextInt();
            p[i] = in.nextInt();
            q[i] = in.nextInt();
            // 记录商品的最小价值
            minValue = Math.min(minValue, v[i]);
        }
        in.close();
        maxValue = 0;
        // 商品i是否选择
        boolean[] isSelected = new boolean[m];
        // dp[i] 表示不超过i
        backTrack(isSelected, v, q, 0, N, p);
    }

    public static void backTrack(boolean[] isSelected, int[] v, int[] q, int start, int value, int[] p) {
        if (value < minValue) {
            maxValue = Math.max(maxValue, countValue(isSelected, p));

        }

    }

    // 计算满意度
    public static int countValue(boolean[] isSelected, int[] p) {
        int count = 0;
        for (int i = 0; i < isSelected.length; i++) {
            if (isSelected[i]) {
                count += p[i];
            }
        }
        return count;
    }
}