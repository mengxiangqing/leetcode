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
        int left = 1;
        int right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, S) != -1) {
                left = L + 1;
            } else {
                right = L;
            }
        }
        int start = search(left - 1,S);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    // 寻找L长度的重复字符串，如果找到返回首字母下标，负责返回-1
    public static int search(int L, String S) {

        HashSet<Long> sHashSet = new HashSet<>();
       
        for (int i = 0; i + L <= S.length(); i++) {
            String subSet = S.substring(i, i + L);
            Long vlaue = hashString(subSet);
            if (sHashSet.contains(vlaue)) {
                return i;
            } else
                sHashSet.add(vlaue);
        }

        return -1;
    }

    private static Long hashString(String str) {

        long h = 0;
        for (int i = 0; i != str.length(); ++i) {
            h = 26 * h + str.charAt(i);
        }
        return h % Long.MAX_VALUE;

    }

}

// @lc code=end
