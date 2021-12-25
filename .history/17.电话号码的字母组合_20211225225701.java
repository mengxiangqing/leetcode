imprt jva.utilArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String [] num=new String[10];
        num[2]="abc";
        num[3]="def";
        num[4]="ghi";
        num[5]="jkl";
        num[6]="mno";
        num[7]="pqrs";
        num[8]="tuv";
        num[9]="wxyz";
        if(digits.length()==0)return res;
        else{
            
        }

        
        return res;
    }
}
// @lc code=end

