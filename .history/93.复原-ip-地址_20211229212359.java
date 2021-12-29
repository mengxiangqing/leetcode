import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solutio {
    public List<String> restoreIpAddresses(String s) {
        // 也就是把字符串切分成四段，每段要符合条件
        List<String> res = new ArrayList<>();
        if (s.length() < 4)
            return res;
        if (s.length() == 4) {
            res.add(s.charAt(0) + "." + s.charAt(1) + "." + s.charAt(2) + "." + s.charAt(3));
            return res;
        }
        // 记录3个点的位置
        List<Integer> point = new ArrayList<>();
        backTrack(res, point, s, 1);
        return res;

    }

    // 转换成Ip地址格式
    private static String transString(List<Integer> point, String s) {
        String result = "";
        result += s.substring(0, point.get(0));
        result += ".";
        result += s.substring(point.get(0), point.get(1));
        result += ".";
        result += s.substring(point.get(1), point.get(2));
        result += ".";
        result += s.substring(point.get(2));

        return result;
    }

    private void backTrack(List<String> res, List<Integer> point, String s, int start) {
        if (point.size() == 3) {
            res.add(transString(point, s));
            return;
        }
        for (int i = start; i < s.length() - 1; i++) {
            if (i == 1) {
                String temp = s.substring(0, i);
                if (!isValid(temp)) {
                    continue;
                }
            }
            point.add(i);
            backTrack(res, point, s, i + 1);
            point.remove(i);
            
        }
    }

    private boolean isValid(String temp) {
        char[] arr = temp.toCharArray();
        
        return false;
    }
}
// @lc code=end
