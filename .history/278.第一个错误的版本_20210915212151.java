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
        int firstBadVersion = n;
        if (n == 1)
            return n;
        else {
            
            int low = 1;
            int high = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (isBadVersion(mid) && !(isBadVersion(mid - 1)))
                    return mid;
                else if (isBadVersion(mid))
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return n;
        }
    }
}
// @lc code=end
