/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {

  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    int[] next = new int[needle.length()];
    getNext(next, needle);
    int j = 0;
    for (int i = 0; i < haystack.length(); i++) {
      while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
        j = next[j - 1];
      }
      if (haystack.charAt(i) == needle.charAt(j)) {
        j++;
      }
      if (j == needle.length() ) return i - needle.length() + 1;
    }
    return -1;
  }

  public void getNext(int[] next, String s) {
    int j = 0;
    // i从1开始，next是前缀表，i为0没有意义，因为一个元素根本不存在前后缀
    for (int i = 1; i < next.length; i++) {
      // 当不匹配是 j开始回退
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = next[j - 1];
      }
      // 匹配是j跟随i向后移动
      if (s.charAt(i) == s.charAt(j)) {
        j++;
      }
      // 记录前缀表
      next[i] = j;
    }
  }
}
// @lc code=end
