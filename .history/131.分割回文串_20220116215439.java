import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * 
 * [131] 分割回文串
 */

// @lc code=start
class Solutio {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 1)
            return Arrays.asList(Arrays.asList(s));

        // 将长度为1的子串加进去
        List<String> one = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            one.add(String.valueOf(s.charAt(i)));
        }
        res.add(one);

        // 分隔符个数从 len-1 到 1
        for (int lenOfPoint = s.length() - 2; lenOfPoint > 0; lenOfPoint--) {
            //分隔符位置    
            List<Integer> position = new ArrayList<>();
            // 找position
            backTrack(s, position, lenOfPoint);

        }
        return res;
    }

    private void backTrack(String s, List<String> path, int[] position, int lenOfPoint) {

        for (int i = 1; i < s.length() - 1; i++) {

        }
    }

    public List<String> split_S(String s, List<Integer> position) {
        List<String> res = new ArrayList<>();
        if (position.size() == 1) {
            res.add(s.substring(0, position.get(0)));
            res.add(s.substring(position.get(0)));
            return res;
        } else {

            res.add(s.substring(0, position.get(0)));

            for (int i = 0; i < position.size() - 1; i++) {
                res.add(s.substring(position.get(i), position.get(i + 1)));
            }

            res.add(s.substring(position.get(position.size() - 1)));
        }
        return res;

    }

    public boolean isHui(String s) {
        if (s.length() <= 1)
            return true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
}
// @lc code=end
