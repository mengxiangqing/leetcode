import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        //dp[i][j]表示s.substring(i,j)是否有
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                wordDict.contains(s.substring(i, j));

            }
        }
        return false;
    }
}
// @lc code=end

