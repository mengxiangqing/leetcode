/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);

    }
    /**
     * 
     * @param num
     * @param index 某个数开始的位置
     * @param count 数的个数
     * @param prevprev 前一个的前一个
     * @param prev 前一个
     * @return
     */
    public boolean dfs(String num, int index, int count, long prevprev, long prev) {
        //终止条件，字符串到尾了，看有几个数字
        if (index >= num.length())
            return count > 2;
        long cur = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);
            if (num.charAt(index) == '0' && i > index) {
                //以0开头，不行
                return false;
            }
            //将新的字符加进来
            cur = cur * 10 + c - '0';
            if (count >= 2) {
                long sum = prev + prevprev;
                //数太大了，不行
                if (cur > sum)
                    return false;
                //当前数小，可能是位数还不够
                if (cur < sum)
                    continue;
            }
            if (dfs(num, i + 1, count + 1, prev, cur))
                return true;
        }
        return false;
    }
}
// @lc code=end
