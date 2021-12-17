import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */

// @lc code=start
class Solutio {
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
