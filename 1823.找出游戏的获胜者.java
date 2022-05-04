import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1823 lang=java
 *
 * [1823] 找出游戏的获胜者
 */

// @lc code=start
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int start = 0;
        while (list.size() > 1) {

            int size = list.size();
            int v_k = k % size;
            int outIndex = (start + v_k - 1+size) % size;
            list.remove(outIndex);
            start = outIndex;
        }

        return list.get(0);

    }

}
// @lc code=end

