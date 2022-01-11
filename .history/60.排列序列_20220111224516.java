/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    public static int count = 0;
    public static String res = "";

    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        res = "";
        boolean[] numIsUse = new boolean[n];
        StringBuilder sb = new StringBuilder();
        backTrack(sb, numIsUse, n, k);
        return res;
    }

    private void backTrack(StringBuilder sb, boolean[] numIsUse, int n, int k) {
        if (sb.length() == n) {
            count++;
            if (count == k) {
                res = new String(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= n && res.equals(""); i++) {
            if (numIsUse[i - 1] == false) {
                numIsUse[i - 1] = true;
                sb.append(i);
                backTrack(sb, numIsUse, n, k);
                sb.deleteCharAt(sb.length() - 1);
                numIsUse[i - 1] = false;
            }
        }
    }
}
// @lc code=end
