/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public: 
    unordered_map<TreeNode*,int> dp;
    int rob(TreeNode* root){
        return robb(root);
    }
    int robb(TreeNode* root){
        if(root==nullptr){
            return 0;
        }
        if(dp.count(root)){
            return dp[root];
        }
        int take=root->val;
        if(root->left){
            take+=robb(root->left->left);
            take+=robb(root->left->right);
        }
        if(root->right){
            take+=robb(root->right->left);
            take+=robb(root->right->right);
        }
        int exc=robb(root->left)+robb(root->right);
        return dp[root]=max(take,exc);
    }
};