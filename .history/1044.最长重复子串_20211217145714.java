import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */

// @lc code=start
class Solution {
    /*
     * Rabin-Karp与多项式滚动哈希。
     * 搜索给定长度的子字符串
     * 发生至少2次。
     * 如果子字符串退出和-1则返回启动位置。
     */
    public int search(int L, int a, long modulus, int n, int[] nums) {
        // 计算String s的散列[：l]
        long h = 0;
        for (int i = 0; i < L; ++i)
            h = (h * a + nums[i]) % modulus;

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet<Long>();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i)
            aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h))
                return start;
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // 将字符串转换为整数数组以实现恒定的时间片
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = (int) S.charAt(i) - (int) 'a';
        // 滚动哈希函数的基础值
        int a = 26;
        // 滚动哈希函数的模数值避免溢出
        long modulus = (long) Math.pow(2, 32);

        // 二分查找 L = 重复字符串长度
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1)
                left = L + 1;
            else
                right = L;
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }
}

// @lc code=end
