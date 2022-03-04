/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = countOnes(i);

        }
        return nums;
    }
    /**
     * Brian Kernighan算法：对于任意整数 x，令 x=x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     * @param x
     * @return x的二进制中1的个数
     */
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
// @lc code=end

