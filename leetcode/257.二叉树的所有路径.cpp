/*
 * @lc app=leetcode.cn id=257 lang=cpp
 *
 * [257] 二叉树的所有路径
 */
#include <iostream>
#include <string>
#include <vector>
#include <numeric>
using namespace std;
/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
// @lc code=start
class Solution
{
public:
    vector<string> binaryTreePaths(TreeNode *root)
    {
        vector<string> res;
        string path;
        construct_path(root, res, "");
        return res;
    }

    /**
     * @brief
     *
     * @param root
     * @param paths 最终结果
     * @param path 暂存路径
     */
    void construct_path(TreeNode *root, vector<string> &paths, string path)
    {
        if (root != nullptr)
        {
            path += to_string(root->val); // int转换成string
            if (root->left == nullptr && root->right == nullptr)
            {
                //叶子结点
                paths.push_back(path);
            }
            else
            {
                path += "->";
                construct_path(root->left, paths, path);
                construct_path(root->right, paths, path);
            }
        }
    }
};
// @lc code=end
