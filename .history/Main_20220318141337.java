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
        minValue = Integer.MAX_VALUE;
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
        // dp[i][j] 表示前i个物品中不超过价值j的最大满意度
        int[][] dp = new int[m + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                //0个物品和0个价值的最大满意度为0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    //当q[i]==0是主件
                    if (q[i] == 0) {
                        int fu_count = 0;
                        for (int qi : q) {
                            if (qi == i + 1) {
                                fu_count++;
                            }
                        }
                        if (fu_count == 0) {
                            //没有附件

                            dp[i][j] = Math.max(dp[i-1][j]+v[i]*p[i], b);

                        }
                    }
                }
            }
        }

        System.out.println(maxValue);
    }




}