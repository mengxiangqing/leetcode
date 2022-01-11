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
        StringBuilder sb = new StringBuilder();
        backTrack(res, sb, numIsUse, n,k,0);
        return res;
    }

    private void backTrack(String res, StringBuilder sb, boolean[] numIsUse, int n,int k,int count) {
        if (sb.length() == n) {
            count++;
            if (count == k) {   
                res=new String(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= n&&res.equals(""); i++) {
            if (numIsUse[i - 1] == false) {
                numIsUse[i - 1] = true;
                sb.append(i);
                backTrack(res, sb, numIsUse, n,k,count);
                sb.deleteCharAt(sb.length() - 1);
                numIsUse[i - 1] = false;
            }
        }
    }
}
// @lc code=end
