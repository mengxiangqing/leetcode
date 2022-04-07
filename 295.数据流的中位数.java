import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> queA;
    PriorityQueue<Integer> queB;

    public MedianFinder() {
        //小根堆，存储较大的一半
        queA = new PriorityQueue<>();
        // 大根堆存储较小的一半
        queB = new PriorityQueue<>((x1, x2) -> x2.compareTo(x1));
    }

    public void addNum(int num) {
        if (queA.size() == queB.size()) {
            queB.offer(num);
            queA.offer(queB.poll());
        } else {
            queA.offer(num);
            queB.offer(queA.poll());
        }
    }

    public double findMedian() {
        double res = 0;
        if (queA.size() == queB.size()) {
            res = (queA.peek() + queB.peek()) / 2.0;
        } else {
            // 奇数
            res = queA.peek() / 1.0;
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
