/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        //双重循环超时
        for (int i = 0; i < height.length; i++) {
            
            int left = i;
            int right = height.length - 1;
            while (left < right) {
                if (height[left] + (right - left) < height[left + 1]) {
                    left++;
                }
                if (height[right] + (right - left) < height[right - 1]) {
                    right--;
                }
                int num = (height[right] < height[left] ? height[right] : height[left])*(right-left);
                max = num > max ? num : max;
                
            }
        }
        return max;

    }
}
// @lc code=end

