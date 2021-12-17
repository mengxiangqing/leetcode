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
        while (left <= right) {
            L = left + (right - left) / 2;
            if(search()==)
        }
    }

    public static int search() {
        
        return 0;
    }
}

// @lc code=end
