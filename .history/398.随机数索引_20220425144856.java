import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    //蓄水池抽样算法
    public int pick(int target) {
      int cnt = 0;
      int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
            cnt++;
     if(random.nextInt(cnt)==0)res = i;
            }
        }
        return res;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

