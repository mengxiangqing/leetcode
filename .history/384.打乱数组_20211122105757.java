import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    int[] nums;
    int[] origin;

    public Solution(int[] nums) {
        this.nums = nums;
        this.origin = nums;

    }
    
    public int[] reset() {
        
        return nums;

    }
    
    public int[] shuffle() {


    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

