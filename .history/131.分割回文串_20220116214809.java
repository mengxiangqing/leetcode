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
            // 分隔符位置,lenOfPoint是个数
            int[] postion = new int[lenOfPoint];
            // 分割成lenOfPoint+1个子串
            List<String> path = new ArrayList<>();
            backTrack(s, path, postion, lenOfPoint);

        }
        return res;
    }

    private void backTrack(String s, List<String> path, int[] postion, int lenOfPoint) {

        for (int i = 1; i < s.length() - 1; i++) {

        }
    }

    public List<String> split_S(String s, List<Integer> postion) {
        List<String> res = new ArrayList<>();
        res.add(s.substring(1,postion.get(1)));
        for (int i = 0; i < postion.size(); i++) {
            res.add(s.substring(postion.get(i), postion.get(i + 1)));
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
