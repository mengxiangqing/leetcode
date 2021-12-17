import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */

// @lc code=start
class Solution {
    public String longestDupSubstring(String S) {
        int n = S.length();

        int left = 0;
        int right = n - 1;
        int L;
        int[] len_isDupli = new int[n];
        while (left <= right) {
            L = left + (right - left) / 2;
            int isDupli = search();
            if (search() != -1) {

            } else {

            }
        }
    }

    //寻找L长度的重复字符串，如果找到返回首字母下标，负责返回-1
    public static int search() {
        
        return -1;
    }
}

// @lc code=end
