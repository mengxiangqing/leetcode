/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump1(int[] nums) {
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    pos = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public int jump(int[] nums) {
        int step = 0;
        int pos = 0;//当前着陆点
        int max = 0;//能跳的最远
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max, nums[i] + i);
            // 到达上次能到达的右边界
            if (i == pos) {
                pos = max;
                step++; // 进入下一次跳跃
            }
        }
        return step;
    }
}
// @lc code=end

