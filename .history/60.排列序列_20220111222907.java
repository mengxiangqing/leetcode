import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solutio {
    public String getPermutation(int n, int k) {
        String res = "";
        if (n == 1)
            return "1";
        boolean[] numIsUse = new boolean[n];
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(resList, sb, 1, n);
        return resList.get(k);
    }

    private void backTrack(List<String> resList, StringBuilder sb, int start, int n) {
        if (sb.length() == n) {
            resList.add(new String(sb.toString()));
            return;
        }
        for (int i = 1; i <= n; i++) {
            
            sb.append(i);
            backTrack(resList, sb, i + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end
