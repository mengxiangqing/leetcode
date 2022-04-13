import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxNum = nums[0];
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            if (hashMap.get(num) > nums.length / 2)
                maxNum = num;
        }
        return maxNum;
    }
}
// @lc code=end
