import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solutio {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j =i+1; j <n+1; j++) {
                if (dp[i] >= 0 && wordDict.contains(s.substring(i, j))) {
                    dp[j] = i;
                    if (temp == 0) {
                        temp = 1;
                        i = j;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return res;

    }
}
// @lc code=end

