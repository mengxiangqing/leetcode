import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {
    Deque<Integer> que;
    public RecentCounter() {
        que = new ArrayDeque<>();
    }

    public int ping(int t) {
        que.addLast(t);
        while (que.getFirst() < t - 3000) {
            que.removeFirst();
        }
        return que.size();

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

