import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int superEggDrop(int k, int n) {
        return dp(k, n);

    }

    private int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0)
                ans = 0;
            else if (k == 1)
                ans = n;
            else {
                int low = 1;
                int high = n;
                while (low + 1 < high) {

                }
            }
        }
        return 0;
    }
}
// @lc code=end

