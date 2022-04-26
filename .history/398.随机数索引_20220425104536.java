import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i]).add(i);
            }
            else {
                hashMap.put(nums[i], new ArrayList<>(Arrays.asList(i)));
        }
        }
    }

    public int pick(int target) {
        List<Integer> temp = hashMap.get(target);
        if (temp.size() == 1)
            return temp.get(0);
        else {

            int i = (int) (Math.random() * 10 *( temp.size()-1)) / 10;
            return temp.get(i);
        }

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

