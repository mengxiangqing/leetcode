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

        List<String> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        backTrack(res, path, s, 0);

        return res.size();
    }

    private void backTrack(List<String> res, List<String> path, String s, int index) {
        if (index == s.length()) {
            String str = "";
            for (String string : path) {
                str += string;
            }
            if (!res.contains(str)) {
                res.add(str);

            }
        }

            for (int j = index + 1; j <= s.length(); j++) {
                String s1 = s.substring(index, j);
                if (isValid(s1)) {
                    path.add(converse(s1));
                    backTrack(res, path, s, j);
                    path.remove(path.size() - 1);


            }
        }
    }

    public String converse(String s) {
        return String.valueOf((char)(Integer.parseInt(s) + 'A'-1));
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
