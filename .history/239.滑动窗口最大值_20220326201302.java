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
        int n = nums.length - k + 1;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }

        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        res[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
            //在左边界前面就出队列
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
// @lc code=end
