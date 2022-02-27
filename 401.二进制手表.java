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
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int count = Integer.bitCount(i) + Integer.bitCount(j);
                if (count == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(":");
                    if (j < 10)
                        sb.append('0');
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}
// @lc code=end

