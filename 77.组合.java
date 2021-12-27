import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        List<Integer> path = new ArrayList<>();
        backTrack(res, path, arr, k,0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> path, int[] arr, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            backTrack(res, path, arr, k, i+1);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

