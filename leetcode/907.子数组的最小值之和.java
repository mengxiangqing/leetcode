import java.lang.Thread.State;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
class Solution {
    static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) {
                r[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                l[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            long a = i - l[i];
            long b = r[i] - i;
            res += a * b % MOD * arr[i] % MOD;
            res %= MOD;
        }
        return res;
    }
}
// @lc code=end
