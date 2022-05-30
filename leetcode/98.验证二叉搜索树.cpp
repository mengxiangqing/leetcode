/*
 * @lc app=leetcode.cn id=98 lang=cpp
 *
 * [98] 验证二叉搜索树
 */

/**
 * Definition for a binary tree node.
 */
// #include <iostream>
// using namespace std;
// struct TreeNode
// {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };
// @lc code=st0art
class Solution
{
public:
    long long pre = LLONG_MIN;
    // 中序遍历
    bool isValidBST(TreeNode *root)
    {
        if (root == nullptr)
            return true;
        if (!isValidBST(root->left))
            return false;
        if (root->val <= pre)
            return false;
        pre = root->val;
        return isValidBST(root->right);
    }
};
// @lc code=end
