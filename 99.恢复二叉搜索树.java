import java.util.List;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int pre = Integer.MIN_VALUE;
    int x = Integer.MIN_VALUE;
    int y = Integer.MIN_VALUE;

    // 中序遍历
    public void orderTrav(TreeNode root, List<Integer> num) {
        if (root.left != null) {
            orderTrav(root.left, num);
        }
        num.add(root.val);
        if (root.right != null) {
            orderTrav(root.right, num);
        }
    }

    public void orderTravHid(TreeNode root) {
        if (root.left != null) {
            orderTravHid(root.left);
        }
        // System.out.println(pre+" "+ root.val);

        if (pre > root.val) {
            x = root.val;
            if (y == Integer.MIN_VALUE) {
                //记录第一个不合适结点
                y = pre;
            } else
                return;
        }
        pre = root.val;
        if (root.right != null) {
            orderTravHid(root.right);
        }
    }

    public void recoverTree(TreeNode root) {
        // List<Integer> nums = new ArrayList<>();
        orderTravHid(root);

        // int index1 = -1, index2 = -1;
        // for (int i = 0; i + 1 < nums.size(); i++) {
        // if (nums.get(i) > nums.get(i + 1)) {
        // index2 = i + 1;
        // if (index1 == -1) {
        // index1 = i;
        // } else
        // break;
        // }
        // }
        recover(root, 2, x, y);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (count-- == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
}
// @lc code=end
