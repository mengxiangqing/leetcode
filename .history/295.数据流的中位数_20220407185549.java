import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> que;
    public MedianFinder() {
        que = new PriorityQueue<>();
    }

    public void addNum(int num) {
        que.offer(num);
    }

    public double findMedian() {
        double res = 0;
        //奇数
        if (que.size() % 2 != 0) {

        } else {

        }
        return res;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

