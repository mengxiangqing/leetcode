import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int numOfResult = 0;
        Stack<Character> sq = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                sq.add(s.charAt(i));
            else if (s.charAt(i) == ')') {
                
            }            
        }
        return numOfResult;

    }
}
// @lc code=end
