import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
   HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if(hashMap.containsKey(n))return hashMap.get(n);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            count += leftNum * rightNum;

        }
        hashMap.put(n, count);

        return count;

    }
}
// @lc code=end
