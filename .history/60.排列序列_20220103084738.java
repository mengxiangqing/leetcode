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
        //又
        if (n == 1)
            return "1";
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
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
        for (int i = start; i <= n; i++) {
            sb.append(i);
            backTrack(resList, sb, i + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end
