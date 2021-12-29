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
        //也就是把字符串切分成四段，每段要符合条件
        List<String> res = new ArrayList<>();
        if (s.length() < 4)
            return res;
        if (s.length() == 4) {
            res.add(s.charAt(0) + "." + s.charAt(1) + "." + s.charAt(2) + "." + s.charAt(3));
            return res;
        }
        char[] arr = s.toCharArray();
        //记录四个点的位置
        List<Integer> point = new ArrayList<>();
      
        backTrack();
        return res;

    }

    private static String transString(List<Integer> point, String s) {
        String result = "";
        result += s.substring(0, point.get(0));
        return result;
    }
    private void backTrack() {
        
    }
}
// @lc code=end

