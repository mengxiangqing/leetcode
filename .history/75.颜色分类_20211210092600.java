/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int temp;
        int red = 0;
        int blue = n - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;
                red++;
            }
            if (nums[i] == 2) {
                temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;
                blue--;
                if (nums[i] != 1) {
                    i--;
                }
            }
            
        }
        
    }
}
// @lc code=end

