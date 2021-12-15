import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] qIndex = new int[n];
        for(int i=0;i<n;i++){
            qIndex[quiet[i]] = i;
        }
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        int[][] richArr = new int[n][n];
        for(int[] rich:richer){
            int larger =rich[0]; 
            int ind = ++richArr[larger][0];
            richArr[larger][ind] = rich[1];
        }
        for(int i=0;i<n;i++){
            dfs(ans,richArr, qIndex[i], qIndex[i]);
        }
        return ans;
    }

    private void dfs(int[] ans, int[][] richArr, int person , int quietPerson  ){
        if(ans[person]>=0) return;
        ans[person] = quietPerson;
        for(int i=1;i<=richArr[person][0];i++){
            dfs(ans, richArr, richArr[person][i], quietPerson );
        }
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/loud-and-rich/solution/xuan-nao-he-fu-you-by-leetcode-solution-jnzm/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// @lc code=end
