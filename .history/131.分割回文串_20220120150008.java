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
    private int[][] isHuiArray;

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 1)
            return Arrays.asList(Arrays.asList(s));
        int lenOfStr = s.length();
        isHuiArray = new int[lenOfStr][lenOfStr];
        // 将长度为1的子串加进去
        List<String> one = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            one.add(String.valueOf(s.charAt(i)));
            isHuiArray[i][i] = 1;
        }
        res.add(one);
        if (isHui(s)) {
            res.add(Arrays.asList(s));
        }

        // 分隔符个数从 len-1 到 1
        for (int lenOfPoint = s.length() - 2; lenOfPoint > 0; lenOfPoint--) {
            // 分隔符位置
            List<Integer> position = new ArrayList<>();
            // 找符合回文串的position
            backTrack(res, s, position, lenOfPoint, 1);

        }
        return res;
    }

    private void backTrack(List<List<String>> res, String s, List<Integer> position, int lenOfPoint, int start) {
        if (position.size() == lenOfPoint) {
            List<String> set = split_S(s, position);
            if (!set.isEmpty())
                res.add(set);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            position.add(i);
            backTrack(res, s, position, lenOfPoint, i + 1);
            position.remove(position.size() - 1);
        }
    }

    public List<String> split_S(String s, List<Integer> position) {
        List<String> res = new ArrayList<>();

        String s0 = s.substring(0, position.get(0));
        if (isHuiArray[0][position.get(0)-1] == 1 || isHui(s0)) {
            isHuiArray[0][position.get(0)-1] = 1;
            res.add(s0);
        } else
            return new ArrayList<>();
        for (int i = 0; i < position.size() - 1; i++) {
            s0 = s.substring(position.get(i), position.get(i + 1));
            if (isHuiArray[position.get(i)][position.get(i + 1)-1] == 1 || isHui(s0)) {
                isHuiArray[position.get(i)][position.get(i + 1)-1] = 1;
                res.add(s0);
            } else
                return new ArrayList<>();
        }

        s0 = s.substring(position.get(position.size() - 1));
        if (isHuiArray[position.get(position.size() - 1)][s.length() - 1] == 1 || isHui(s0)) {
            isHuiArray[position.get(position.size() - 1)][s.length() - 1] = 1;
            res.add(s0);
        } else
            return new ArrayList<>();

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
