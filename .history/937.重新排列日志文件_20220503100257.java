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
                String[] o1s = o1.split(" ");
                String[] o2s = o2.split(" ");
                //o1数字日志
                if (o1s[1].charAt(0) >= '0' && o1s[1].charAt(0) <= '9') {
                    // o2数字日志
                    if (o2s[1].charAt(0) >= '0' && o2s[1].charAt(0) <= '9')
                        return -1;//按原顺序
                    else//o2是字母，调换顺序
                        return 1;
                } else {//o1是字母
                    //o2是数组
                    if (o2s[1].charAt(0) >= '0' && o2s[1].charAt(0) <= '9')
                    {
                        return 1;
                    } else {
                        //都是字母
                        return o1.substring(o1s[0].length()).compareTo(o2.substring(o2s[0].length()));
                    }

                }
            }

        });
        return logs;
    }
}
// @lc code=end
