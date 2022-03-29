/*
 * @lc app=leetcode.cn id=1544 lang=java
 *
 * [1544] 整理字符串
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
       StringBuilder sb = new StringBuilder();
       int sbIndex = -1;
       for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           if(sb.length()>0 && ch ^ sb.charAt(sbIndex)==32 && ch!=sb.charAt(sbIndex)){
               sb.deleteCharAt(sbIndex);
               sbIndex--;
           }
           else {
               sbIndex++;
               sb.append(ch);

            }
       }
       return sb.toString();
    }
}
// @lc code=end
