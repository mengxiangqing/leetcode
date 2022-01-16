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
            // 分隔符位置
            List<Integer> position = new ArrayList<>();
            // 找符合回文串的position
            backTrack(res, s, position, lenOfPoint,1);

        }
        return res;
    }

    private void backTrack(List<List<String>> res, String s, List<Integer> position, int lenOfPoint,int start) {
        if (position.size() == lenOfPoint) {
            List<String> set = split_S(s, position);
            boolean isTrue = true;
            for (String string : set) {
                if (!isHui(string)) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue)
                res.add(set);
            return;
        }
        for (int i = start; i < s.length()-1; i++) {
            position.add(i);
            backTrack(res, s, position, lenOfPoint,i+1);
            position.remove(position.size() - 1);
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
