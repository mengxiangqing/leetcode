/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    int record[] = new int[26];
    if (ransomNote.length() > magazine.length()) return false;
    for (int i = 0; i < magazine.length(); i++) {
        record[magazine.charAt(i) - 'a']++;
    }
    for (int i = 0; i < ransomNote.length(); i++) {
        char c = ransomNote.charAt(i);
        record[c-'a']--;
        if (record[c-'a'] < 0)
            return false;
    }
    return true;
  }
}
// @lc code=end
