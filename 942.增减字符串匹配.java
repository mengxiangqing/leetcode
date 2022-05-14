import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
class Solution {
    boolean[] used;

    public int[] diStringMatch(String s) {
        int n = s.length();
        used = new boolean[n + 1];
        List<Integer> res = new ArrayList<>();
        backTrack(res, s);

        return res.stream().mapToInt(Integer -> Integer.intValue()).toArray();
    }

    private boolean backTrack(List<Integer> res, String s) {
        if (res.size() == s.length() + 1) {
            return true;
        } else {
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    continue;
                } else {
                    if (res.size() == 0){
                        used[i] = true;
                        res.add(i);
                    }
                    else {
                        if (((res.get(res.size() - 1) < i) && s.charAt(res.size() - 1) == 'I')
                                || (res.get(res.size() - 1) > i) && s.charAt(res.size() - 1) == 'D') {
                            used[i] = true;
                            res.add(i);
                        } else
                            continue;
                    }

                    if (backTrack(res, s))
                        return true;
                    else {
                        res.remove(res.size() - 1);
                        used[i] = false;
                    }

                }
            }

        }
        return false;
    }
}

// @lc code=end
