/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solutio {
    public int myAtoi(String s) {
        int res = 0;
        String ans = "";
        boolean isZheng = true;
        s = s.trim();
        if (s.charAt(0) == '-') {
            isZheng = false;
            s = s.substring(1);
        }
        int i = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans += s.charAt(i);
            i++;
        }
        res = Integer.parseInt(ans);
        return res;
    }
}
// @lc code=end
