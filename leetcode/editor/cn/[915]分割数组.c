//给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得： 
//
// 
// left 中的每个元素都小于或等于 right 中的每个元素。 
// left 和 right 都是非空的。 
// left 的长度要尽可能小。 
// 
//
// 在完成这样的分组后返回 left 的 长度 。 
//
// 用例可以保证存在这样的划分方法。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,0,3,8,6]
//输出：3
//解释：left = [5,0,3]，right = [8,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,0,6,12]
//输出：4
//解释：left = [1,1,1,0]，right = [6,12]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。 
// 
//
// Related Topics 数组 👍 211 👎 0
#include<stdio.h>
int partitionDisjoint(int *nums, int numsSize);
int main() {
    int nums[] = {5, 0, 3, 8, 6};
    partitionDisjoint(nums, 5);
}
//leetcode submit region begin(Prohibit modification and deletion)


int partitionDisjoint(int *nums, int numsSize) {
    int count = 1;
    while (count < numsSize) {
        int max = 0;
        for (int i = 0; i < count; ++i) {
            max = max > nums[i] ? max : nums[i];
        }
        for (int i = count; i < numsSize; ++i) {
            if (max < nums[i]) {
                count++;
                break;
            }
        }
        return count;
    }

    return count;
}
//leetcode submit region end(Prohibit modification and deletion)
