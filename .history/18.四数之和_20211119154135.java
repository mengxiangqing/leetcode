import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);// 排序
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target)
                break;
            if (i > 0&&(nums[i] == nums[i - 1]))
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if ((nums[j] == nums[j - 1]) && j > 1) {// 跳过重复的，j>1确保第一次不被跳过
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int num = nums[i] + nums[j] + nums[l] + nums[r];
                    if (num == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                    } else if (num < target) {
                        l++;
                    } else
                        r++;

                }
            }
        }

        return res;
    }
}
// @lc code=end
