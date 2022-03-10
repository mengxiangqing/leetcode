import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solutio {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        List<String> path = new ArrayList<>();
        backTrack(res, s, wordDict, 0, path);
        return res;

    }

    private void backTrack(List<String> res, String s, List<String> wordDict, int start, List<String> path) {
        if (start == s.length()) {
            String str = "";
            for (int i = 0; i < path.size(); i++) {
                str += path.get(i);
                if (i != path.size() - 1)
                    str += " ";

            }
            res.add(str);

        }
        for (int i = start+1; i <=s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                path.add(s.substring(start, i));
                backTrack(res, s, wordDict, i + 1, path);
                path.remove(path.size() - 1);


            }
        }
    }
}
// @lc code=end
