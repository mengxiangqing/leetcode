/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        //默认0为开，1为关
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            sw(num, i);
        }
           
        return n;

    }

    private void sw(int[] num, int i) {
    }
}
// @lc code=end

