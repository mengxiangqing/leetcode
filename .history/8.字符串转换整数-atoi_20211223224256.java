/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0)
            return 0;
        int res = 0;

        String ans = "";
        boolean isZheng = true;

        s = s.trim();
        if (s.charAt(0) == '-') {
            ans += '-';
            isZheng = false;
            s = s.substring(1);
            
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if (s.length() == 0)//"-"
        return 0;
        if (s.charAt(0) < '0' || s.charAt(0) > '9')
            return 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans += s.charAt(i);
            i++;
        }
        try {
            res = Integer.parseInt(ans);

        } catch (Exception e) {

            if (isZheng)
                return 2147483647;
            else
                return -2147483648;
        }
        return res;
    }
}
// @lc code=end
