/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        int numOfNegative=0;
        for(int i=0;i<nums.lengh;++i){
            if(nums[i]<0)numOfNegative++;
        }
        //去判断k与负数个数大小
        if(numOfNegative<=k){
            for(int i=0;i<nums.lengh;i++){
                if(i<k){
                nums[i]=-nums[i];
                }
                sum+=nums[i];
                return sum;
            }
        }
        else{
            //先把负数转正
            for(int i=0;i<numOfNegative;++i){
                nums[i]=-nums[i];
                sum+=nums[i];
            }
            Arrays.sort(nums);
            int n1=k-numOfNegative;
            if(n1%2==0){
                //偶数不变！
                for(int i=numOfNegative;i<nums.lengh;++i){
                    sum+=nums[i];
                }
                return sum;
            }else{
                for(int i=0;i<nums.lengh;i++){
                    if(i==0)nums[i]=-nums[i];
                    sum+=nums[i];
                }
                return sum;
            }
        }
    }
}
// @lc code=end

