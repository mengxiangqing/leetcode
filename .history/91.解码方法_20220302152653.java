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

    private void backTrack(List<String> res, List<String> path, String s, int index) {
        if (index == s.length()) {

        }
        for (int i = index; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(isValid(s.substring(i,j)))
                path.add(s.substring(i, j));
                backTrack(res, path, s, j+1);
                path.remove(path.size() - 1);
            }
        }
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
