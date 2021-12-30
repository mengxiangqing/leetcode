import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solutio {
    public List<Integer> grayCode(int n) {
        if (n == 1)
            return Arrays.asList(0, 1);
        List<Integer> res = new ArrayList<>();
        backtrack(res, n, 0);
        return res;

    }

    private void backtrack(List<Integer> res, int n, int start) {
        if (res.size() == n) {

        }
        for (int i = start; i < Math.pow(2, n); i++) {
            if()
        }
    }
}
// @lc code=end
