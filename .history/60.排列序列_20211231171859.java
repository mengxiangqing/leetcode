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
        String res = "";
        if (n == 1)
            return "1";
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(resList, sb, 0, n);
        return res;
    }

    private void backTrack(List<String> resList, StringBuilder sb, int i, int n) {
        
    }
}
// @lc code=end

