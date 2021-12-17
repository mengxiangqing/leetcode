import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */

// @lc code=start
class Solution {
    public String longestDupSubstring(String S) {
        String res = "";
        int n = S.length();
        for (int i = n - 1; i >= 0; i--) {
            int start = search(i, S);
            if (start != -1) {
                return S.substring(start, i + start);
            }
        }
        return res;
        // int left = 0;
        // int right = n - 1;
        // int L;
        // int[] len_isDupli = new int[n];
        // while (left <= right) {
        // L = left + (right - left) / 2;
        // int isDupli = search(L);
        // if (search(L) != -1) {
        // len_isDupli[L] = 1;

        // } else {

        // }
        // }
    }

    // 寻找L长度的重复字符串，如果找到返回首字母下标，负责返回-1
    public static int search(int L, String S) {

        HashSet<Long> sHashSet = new HashSet<>();
        for (int i = 0; i + L < S.length(); i++) {
            String subSet = S.substring(i, i + L);
            Long vlaue = hashString(subSet);
        }

        return -1;
    }

    private static Long hashString(String subSet) {
        
        return null;
    }

}

// @lc code=end
