/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solutio {
    public void sortColors(int[] nums) {
        int j = 1;
        int n = nums.length;
        int temp;
        int red = 0;
        int blue = n - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;
                break;
            }
        }
        while (j < blue) {
            while (nums[j] != 1) {
                if (nums[j] == 0) {
                    temp = nums[red];
                    nums[red] = nums[j];
                    nums[j] = temp;
                    red++;
                } else if (nums[j] == 2) {
                    temp = nums[blue];
                    nums[blue] = nums[j];
                    nums[j] = temp;
                    blue--;
                }
            }
            j++;
        }
        
    }
}
// @lc code=end

