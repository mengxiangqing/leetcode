/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solutio {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;
        int n = s.length();
        // f[i]代表字符串的前i个字符s[1...i]的解码方法数
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i<= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }

        }
        return f[n];
    }

}
// @lc code=end
