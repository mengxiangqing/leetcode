/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] newCode = new int[len];
        if (k > 0) {
            for (int i = 0; i < len; i++) {
                int j = (i + 1) % len;
                for (int p = 0; p < k; p++) {
                    newCode[i] += code[j];
                    j = (j + 1) % len;
                }
            }
        }
        if (k < 0) {
            for (int i = 0; i < len; i++) {
                int j = Math.floorMod(i - 1, len);
                for (int q = 0; q < Math.abs(k); q++) {
                    newCode[i] += code[j];
                    j = Math.floorMod(j - 1, len);
                }
            }
        }
        return newCode;
    }
}
// @lc code=end
