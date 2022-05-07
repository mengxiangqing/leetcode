/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    boolean[] used;

    public int minMutation(String start, String end, String[] bank) {

        if (bank.length == 0)
            return -1;
        used = new boolean[bank.length];
        int minMu = minMu(start, end, bank);
        return minMu == bank.length * 2 ? -1 : minMu;

    }

    public int minMu(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        // 将bank的2倍作为默认最大步骤，若最后返回这个值，则说明没有路径
        int minStep = bank.length * 2;
        for (int i = 0; i < bank.length; i++) {
            if (used[i] || countB(start, bank[i]) != 1)
                continue;
            else {
                used[i] = true;
                int temp = minMu(bank[i], end, bank) + 1;
                minStep = Math.min(minStep, temp);
            }
            used[i] = false;
        }

        return minStep;
    }

    /**
     * 计算两个基因序列之间的变化个数
     *
     * @param s1
     * @param s2
     * @return
     */
    public int countB(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count;
    }
}
// @lc code=end
