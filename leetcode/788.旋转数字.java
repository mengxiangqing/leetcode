/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = spinByPerNum(i);
            if (temp != i) {
                count++;
            }
        }
        return count;
    }

    public int spinByPerNum(int n) {
        if (n < 10) {
            int temp = spin(n);
            if (temp == -1) {
                return n;
            }
            return temp;
        } else {
            String s = String.valueOf(n);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int temp = spin(s.charAt(i) - '0');
                if (temp == -1) {
                    return n;
                }
                sb.append(temp);
            }
            return Integer.valueOf(sb.toString());
        }
    }

    public int spin(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 5;
            case 5:
                return 2;
            case 6:
                return 9;
            case 8:
                return 8;
            case 9:
                return 6;
            default:
                // 旋转后数字无效，比如 3、4、7
                return -1;
        }

    }
}
// @lc code=end
