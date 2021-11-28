/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class S {
    public int trap(int[] height) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = height[i] > max ? height[i] : max;
        }
        // 一共max层，一层一层来处理
        int ceng = 1;
        while (ceng <= max) {
            
        }
        return sum;
    }
}
// @lc code=end
