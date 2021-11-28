/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// class Solutio{
//     public int trap(int[] height) {
//         int sum = 0;
//         int max = 0;
//         for (int i = 0; i < height.length; i++) {
//             max = height[i] > max ? height[i] : max;
//         }
//         // 一共max层，一层一层来处理
//         int ceng = 1;
//         while (ceng <= max) {
//             // 先找开头和结尾
//             int start = 0;
//             int end = height.length;
//             for (int i = 0; i < height.length; i++) {
//                 if (height[i] != 0) {
//                     start = i;
//                     break;
//                 }
//             }
//             for (int i = height.length - 1; i >= 0; i--) {
//                 if (height[i] != 0) {
//                     end = i;
//                     break;
//                 }
//             }
//             if (start < end) {
//                 for (int i = start; i < end; i++) {
//                     if (height[i] == 0) {
//                         sum += 1;
//                     }
//                 }
//                 for (int i = 0; i < height.length; i++) {
//                     height[i] = height[i] - 1 < 0 ? 0 : height[i] - 1;
//                 }
//                 ceng++;
//             } else {
//                 break;
//             }

//         }
//         return sum;
//     }
// }
// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;
        int[] leftMax = new int[n];// 下标i及其左边的位置中，height的最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = leftMax[i - 1] > height[i] ? leftMax[i - 1] : height[i];
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = rightMax[i + 1] > height[i] ? rightMax[i + 1] : height[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += leftMax[i] > rightMax[i] - height[i] ? leftMax[i] : rightMax[i] - height[i];
        }
        return ans;
    }
}
// @lc code=end
