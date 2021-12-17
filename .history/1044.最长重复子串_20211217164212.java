import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */

// @lc code=start
class Solutio {
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
        int start = search(left - 1, S);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    // 寻找L长度的重复字符串，如果找到返回首字母下标，负责返回-1
    public static int search(int L, String S) {

        HashSet<Long> sHashSet = new HashSet<>();
        long vlaue = 0;
        long modulus = (long)Math.pow(2, 32);
        int seed = 26;
        for (int i = 0; i < L; ++i)
            vlaue = (vlaue * seed + S.charAt(i)) % modulus;
        sHashSet.add(vlaue);
        long aL = 1;
        for (int i = 1; i <= L; ++i)
            aL = (aL * seed) % modulus;
        for (int i = 1; i + L <= S.length(); i++) {

            vlaue = (vlaue * seed - S.charAt(i - 1) * aL % modulus + modulus) % modulus;
            vlaue = (vlaue + S.charAt(i + L - 1)) % modulus;

            if (sHashSet.contains(vlaue)) {
                return i;
            } else
                sHashSet.add(vlaue);
        }

        return -1;
    }
}

// @lc code=end
