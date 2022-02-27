import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
// 对于非多线程环境中的字符串操作，我们应该使用 StringBuilder 否则使用 StringBuffer 类。
// StringBuffer 是线程安全和同步的，而 StringBuilder 不是。这就是 StringBuilder 比 StringBuffer 快的原因。
class Solution {
    int[] hours = new int[] { 1, 2, 4, 8, 0, 0, 0, 0, 0, 0 };
    int[] minutes = new int[] { 0, 0, 0, 0, 1, 2, 4, 8, 16, 32 };

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        backTrack(turnedOn, 0, 0, 0, res);

        return res;
    }

    private void backTrack(int num, int index, int hour, int minute, List<String> res) {
        if (hour > 11 || minute > 59)
            return;
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(":");
            if (minute < 10)
                sb.append("0");
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
            backTrack(num-1, i+1, hour+hours[i], minute+minutes[i], res);
        }
    }
}
// @lc code=end
