import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=937 lang=java
 *
 * [937] 重新排列日志文件
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                return 0;
            }

        });
        return logs;
    }
}
// @lc code=end
