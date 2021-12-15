import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int dian = quiet.length;
        int bian = richer.length;
        List<Integer>[] graph = new List[dian];
        for (int i = 0; i < dian; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] bianL : richer) {
            
        }
        
        int[] res = new int[dian];
        
        return res;
    }
}
// @lc code=end

