/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        // 默认0为关闭 1为打开
        int[] num = new int[n];
        for (int i = 1; i < +1; i++) {
            sw(num, i);
            System.out.println(num[0]);
        }
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1)
                count++;
        }
        return count;

    }

    private void sw(int[] num, int i) {
        for (int j = 1; j < num.length + 1; j++) {
            if (j % i == 0) {
                num[j - 1] = num[j - 1] == 1 ? 0 : 1;
            }
        }
    }
}
// @lc code=end
