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
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if(i>1&& s.charAt(i-2)!='0' && ((s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0')<=f[i]))

        }
        return 0;
    }

}
// @lc code=end
