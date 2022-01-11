import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        String res = "";
        boolean[] numIsUse = new boolean[n];
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(res, sb, numIsUse, n,k);
        return resList.get(k-1);
    }

    private void backTrack(String res, StringBuilder sb, boolean[] numIsUse, int n,int k) {
        if (sb.length() == n) {
            res=new String(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (numIsUse[i - 1] == false) {
                numIsUse[i - 1] = true;
                sb.append(i);
                backTrack(resList, sb, numIsUse, n);
                sb.deleteCharAt(sb.length() - 1);
                numIsUse[i - 1] = false;
            }
        }
    }
}
// @lc code=end
