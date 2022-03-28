import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
class MyCalendar {
    private List<Integer> used;
    public MyCalendar() {
        used = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        List<Integer> temp = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (used.contains(i))
                return false;
            else
                temp.add(i);

        }
        used.addAll(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

