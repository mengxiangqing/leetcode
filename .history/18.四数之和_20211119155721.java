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
        if (nums == null || nums.length < 4) {
            return res;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target)
                break;
            if (i > 0 && (nums[i] == nums[i - 1]))
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if ((nums[j] == nums[j - 1]) && j > i+1) {// 跳过重复的，j>1确保第一次不被跳过
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int num = nums[i] + nums[j] + nums[l] + nums[r];
                    if (num == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;

                    } else if (num < target) {
                        l++;
                        if ((nums[l] == nums[l - 1]) && l < r) {
                            l++;
                        }
                    } else {
                        r--;
                        if (nums[r] == nums[r + 1] && l < r) {
                            r--;
                        }
                    }

                }
            }
        }

        return res;
    }
}
// @lc code=end
