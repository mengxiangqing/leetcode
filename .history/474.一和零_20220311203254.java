import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solutio {
    int max;

    public int findMaxForm(String[] strs, int m, int n) {
        max = 0;
        // 子集最多m个0，n个1
        int res = 0;
        List<int[]> numStr = new ArrayList<>();
        for (String str : strs) {
            int[] num = countNum(str);
            numStr.add(num);
        }
        int len = strs.length;
        List<String> path = new ArrayList<>();
        backTrack(path, numStr, 0);


        return res;
    }

    private void backTrack(List<String> path, List<int[]> numStr, int start) {
        if (start == numStr.size()) {
            max = Math.max(path.size(), max);
        }
        for (int i = start; i < numStr.size(); i++) {
            for (int j = i+1; j < numStr.size(); j++) {

            }
        }
    }

    /**
     * 计算二进制字符串中0和1的数量
     *
     * @param str
     * @return res[2]
     */
    public int[] countNum(String str) {
        // res[0]代表0的数字，res[1]代表1的数量
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                res[0]++;
            else
                res[1]++;

        }
        return res;
    }
}
// @lc code=end
