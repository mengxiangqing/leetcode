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
        int maxNum = 0;
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            maxNum = hashMap.get(num) > hashMap.get(maxNum) ? num : maxNum;
        }
        return maxNum;
    }
}
// @lc code=end
