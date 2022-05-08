import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        BitSet bs = new BitSet(nums.length + 1);
        if (nums.length <= 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (bs.get(num))
                res.add(num);
            else
                bs.set(num);

        }

        return res;

    }
}
// @lc code=end
