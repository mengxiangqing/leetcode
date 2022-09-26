import java.util.BitSet;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。
 * 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 
 * 以任意顺序返回这两个数字均可。
 * 
 * 示例 1:
 * 
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * 
 * 输入: [2,3]
 * 输出: [1,4]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/missing-two-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int N = n + 2;
        BitSet bs = new BitSet();
        for (int i = 0; i < nums.length; i++) {
            bs.set(nums[i]);
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= N; i++) {
            if (bs.get(i) == false) {
                if (num1 == 0) {

                    num1 = i;
                } else {
                    num2 = i;
                    break;
                }
            }
        }
        return new int[] { num1, num2 };

    }
}