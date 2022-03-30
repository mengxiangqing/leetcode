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
        //初始化need数组
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
            while (needCount > 0 && j < s.length()) {
                // 在t里面
                if (need[s.charAt(j)] > 0) {
                    needCount--;
                }
                need[s.charAt(j)]--;
                j++;
            }
            if (j - i < minSize) {

                minSize = j - i;
                minIndex = i;
            }//左边界右移
            need[s.charAt(i)]++;
            i++;
            needCount++;

            // while (need[s.charAt(i)] < 0) {
            //     need[s.charAt(i)]++;
            //     i++;
            // }

        }
        if (j - i < minSize) {

            minSize = j - i;
            minIndex = i;
        }
        return s.substring(minIndex, minIndex + minSize);
    }

}
// @lc code=end
