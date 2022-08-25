import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            list.add(a);
        }

        list.sort((o1, o2) -> {
            if (Math.abs(o1 - x) != Math.abs(o2 - x)) {
                return Math.abs(o1 - x) - Math.abs(o2 - x);
            } else {
                return o1 - o2;
            }
        });
        List<Integer> ans = list.subList(0, k);
        ans.sort((o1, o2) -> o1.compareTo(o2));

        return ans;
    }
}
// @lc code=end
