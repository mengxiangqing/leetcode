import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 计算结果数组大小
        int n = nums.length - k + 1;
        int[] res = new int[n];
        // [0]值，[1]坐标
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int i = 0;
        // 将前k个加入队列
        for (i = 0; i < k; i++) {
            que.offer(new int[] { nums[i], i });
        }
        // 填充第一个窗口的值
        res[0] = que.peek()[0];
        // 开始滑动窗口
        for (i = k; i < nums.length; i++) {
            que.offer(new int[] { nums[i], i });
            // 当队列最大值不在窗口内,出队
            while (que.peek()[1] < i - k + 1) {
                que.poll();
            }
            res[i - k + 1] = que.peek()[0];
        }
        return res;
    }
}
// @lc code=end
