import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int count = 0;
        int n = s.length();
        List<String> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        backTrack(res, path, s, 0);

        return count;
    }

    private void backTrack(List<String> res, List<String> path, String s, int i) {

    }

    public boolean isValid(String s) {
        if (s.length() == 1)
            return true;
        else if (s.length() == 2) {
            if (s.charAt(0) == '0')
                return false;
            else {
                int num = Integer.parseInt(s);
                if (num <= 26)
                    return true;
            }
        }
        return false;
    }
}
// @lc code=end
