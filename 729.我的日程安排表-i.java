import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
class MyCalendar {
    private TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = treeMap.floorKey(start);
        Integer next = treeMap.ceilingKey(start);
        if ((pre == null || treeMap.get(pre) <= start) && (next == null || end <= next)) {
            treeMap.put(start, end);
            return true;
        } else
            return false;
    }
}
/*
 * 向上，向下，上下限方法
 * HigherKey() - 返回大于指定键的那些键中的最小的键。
 *
 * HigherEntry() - 返回与所有大于指定键的键中最小的键相关的条目。
 *
 * lowerKey() - 返回所有小于指定键的最大键。
 *
 * lowerEntry() - 返回与所有小于指定键的键中最大的键关联的条目。
 *
 * ceilingKey() - 返回大于指定键的那些键中的最小的键。如果映射中存在作为参数传递的键，则它将返回该键。
 *
 * ceilingEntry() - 返回与大于指定键的那些键中最小的键相关的条目。如果映射中存在与传递给自变量的键关联的条目，则返回与该键关联的条目。
 *
 * floorKey() - 返回小于指定键的那些键中最大的键。如果存在作为参数传递的键，它将返回该键。
 *
 * floorEntry() - 返回与小于指定键的那些键中最大的键相关的条目。如果存在作为参数传递的键，它将返回该键。
 */

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end
