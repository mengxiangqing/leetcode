import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

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
        nums = Arrays.copyOfRange(origin, 0, origin.length);
        return nums;

    }

    public int[] shuffle() {
        nums = Arrays.copyOfRange(origin, 0, origin.length);
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            aList.add(nums[i]);
        }
        
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
// @lc code=end
