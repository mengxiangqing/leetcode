/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[n + m];
        int i = 0;
        int j = 0;
        int t = 0;
        while (i < m || j < n) {
            if (nums1[i] < nums2[j]) {
                num[t++] = nums1[i++];
            } else
                num[t++] = nums2[j++];
        }
        nums1 = num;

    }
}
// @lc code=end
