/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solutio {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        // 0 1 2 3 2 1 0 1 2 3
        int flag = 0;
        boolean isAdd = true;
        for (int i = 0; i < s.length(); i++) {
            sb[flag].append(s.charAt(i));
            if (isAdd)
                flag++;
            else
                flag--;
            if (flag == numRows - 1)
                isAdd = false;
            else if (flag == 0)
                isAdd = true;
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += sb[i].toString();
        }
        return res;
    }
}
// @lc code=end
