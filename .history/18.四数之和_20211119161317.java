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
            if (i > 0 && (nums[i] == nums[i - 1]))
                continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 3] + nums[nums.length - 2] < target)
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if ((nums[j] == nums[j - 1]) && j > i + 1) {// 跳过重复的，j>1确保第一次不被跳过
                    continue;
                }
                // if (nums[i] + nums[j + 1] + nums[j + 2] + nums[j] > target)
                //     break;
                // if (nums[i] + nums[nums.length - 1] + nums[j] + nums[nums.length - 2] < target)
                //     continue;
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int num = nums[i] + nums[j] + nums[l] + nums[r];
                    if (num == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {// 去重
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;

                    } else if (num < target) {
                        l++;
                        while ((nums[l] == nums[l - 1]) && l < r) {
                            l++;
                        }
                    } else {
                        r--;
                        while (nums[r] == nums[r + 1] && l < r) {
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
