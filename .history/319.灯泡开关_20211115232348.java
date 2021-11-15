/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // 默认0为关闭 1为打开
        int[] num = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < num.length; j++) {
                if (j % i == 0)
                    num[j - 1] = num[j - 1] == 1 ? 0 : 1;

            }
        }
        num[n - 1] = num[n - 1] == 1 ? 0 : 1;

        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1)
                count++;
        }
        return count;

    }
}
// @lc code=end
