/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        for (int i = 1; i <=n; i++) {
            if(isBadVersion(i))
            {
                break;
                return i;
                }
        }
    }
}
// @lc code=end
