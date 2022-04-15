import javax.swing.text.html.HTMLDocument.RunElement;

/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        // int[] dp = new int[n + 1];
        // for (int i = 2; i <= n; i++) {
        //     int curMax = 0;
        //     for (int j = 1; j < i; j++) {
        //         curMax = Math.max(Math.max(j * (i - j), j * dp[i - j]), curMax);

        //     }
        //     dp[i] = curMax;
        // }
        // return dp[n];
        if (n <= 3)
            return n-1;
        int num3 = n / 3;
        if (n % 3 == 0)
            return (int)Math.pow(3, num3);
        else if (n % 3 == 1) {
            return (int) Math.pow(3, num3 - 1)*4;
        } else {
            return (int) Math.pow(3, num3 ) * 2;
        }
    }
}
// @lc code=end
