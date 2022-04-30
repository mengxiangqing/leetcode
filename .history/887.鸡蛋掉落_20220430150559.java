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
                    int x = (low + high) / 2;
                    int t1 = dp(k - 1, x - 1);
                    int t2 = dp(k, n - x);

                    if (t1 < t2) {
                        low = x;
                    } else if (t1 > t2) {
                        high = x;
                    } else
                        low = high = x;
                }
                ans = 1 + Math.min(Math.max(dp(k - 1, low - 1), dp(k, n - low)),
                        Math.max(dp(k - 1, high - 1), dp(k, n - high)));
            }
            memo.put(n * 100 + k, ans);

        }
        return memo.get(n * 100 + k);

    }
}
// @lc code=end

