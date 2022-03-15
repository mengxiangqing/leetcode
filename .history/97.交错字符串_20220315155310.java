/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        if (n == 0 && m == 0 & len == 0)
            return true;
        if (n + m != len)
            return false;
        // f[i][j]代表s1的前i个元素和s2前j个元素能不能交差组成s3的前i+j个元素
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j ;
                if (i > 0)
                    f[i][j] = f[i][j] || f[i - 1][j] && s1.charAt(i ) == s3.charAt(p);
                if (j > 0)
                    f[i][j] = f[i][j] || f[i][j - 1] && s2.charAt(j ) == s3.charAt(p);
            }
        }

        return f[n][m];
    }
}
// @lc code=end
