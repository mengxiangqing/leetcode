import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solutio {
    public int numDecodings(String s) {

        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        backTrack(res, path, s, 0);

        return res.size();
    }

    private void backTrack(List<String> res, StringBuilder path, String s, int index) {
        if (index == s.length()) {
            String str = path.toString();
            if (!res.contains(str)) {
                res.add(str);

            }
        }
        for (int i = index; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String s1 = s.substring(i, j);
                if (isValid(s1)) {
                    path.append(s1);

                    backTrack(res, path, s, j);
                    path.delete(path.length() - (j - i), path.length());

                }
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
