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
        //四个字符串
        List<StringBuilder> sb = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sb.add(new StringBuilder());
        }
        backTrack();
        return res;

    }

    private void backTrack() {
        
    }
}
// @lc code=end

