/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solutio {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        if (s.length() == t.length()) {
            return s.equals(t) ? s : "";
        }
        int[] need = new int[128];
        // 初始化need数组
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // 记录需要的个数
        int needCount = t.length();

        int minSize = Integer.MAX_VALUE;

        int start = 0;
        // 找到第一个在t中的位置
        while (start < s.length()) {
            if (need[s.charAt(start)] > 0) {
                break;
            }
            start++;
        }
        int i = start, j = start;
        int minIndex = 0;// 记录最小子串的下标
        while (j < s.length()) {
            char c = s.charAt(j);

            if (need[c] > 0)
                needCount--;
            need[c]--;
            if (needCount == 0) {
                // 循环寻找满足条件最右边的左边界
                while (i < j && need[s.charAt(i)] < 0) {
                    need[s.charAt(i)]++;
                    i++;
                }
                if (j - i + 1 < minSize) {
                    minIndex = i;
                    minSize = j - i + 1;
                }
                // 左边界右移，开启下个滑动窗口
                need[s.charAt(i)]++;
                needCount++;
                i++;

            }

            j++;

        }
        return minSize != Integer.MAX_VALUE ? s.substring(minIndex, minIndex + minSize) : "";
    }

}
// @lc code=end
