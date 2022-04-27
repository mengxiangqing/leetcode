import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    //leftTop[i][j]表示能否流向左上边,0 未赋值，1 可以，2 不可以
    short[][] isLeftTop;
    // 表示能否流向右下边
    short[][] isTightDown;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        isLeftTop = new short[m][n];
        isTightDown = new short[m][n];
        return res;
    }

    public static void exploer(int i,int j ,int [][]heights) {

    }
}
// @lc code=end

