import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }


    PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(
      (o1, o2) -> o2.getValue() - o1.getValue()
    );
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      que.add(entry);
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
        res[i] = que.poll().getKey();
    }

    return res;
  }
}
// @lc code=end
