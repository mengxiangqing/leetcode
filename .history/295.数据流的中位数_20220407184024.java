import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        list.sort((x1,x2)->x1.compareTo(x2));
    }

    public double findMedian() {
        double res = 0;
        //奇数
        if (list.size() % 2 != 0) {

                res = list.get(list.size() / 2);

        } else {
            res = (list.get(list.size() / 2) + list.get(list.size() / 2 + 1)) / 2.0;
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

