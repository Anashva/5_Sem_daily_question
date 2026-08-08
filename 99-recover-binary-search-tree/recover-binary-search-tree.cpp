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
    TreeNode* prev=nullptr;
    TreeNode* first=nullptr;
    TreeNode* second=nullptr;
    void recoverTree(TreeNode* root) {
        solve(root);
        int temp=first->val;
        first->val=second->val;
        second->val=temp;
    }
    void solve(TreeNode* root){
        if(!root){
            return;
        }
        solve(root->left);
        if(prev!=nullptr && prev->val>=root->val){
            if(!first){
                first=prev;
            }
            second=root;
        }
        prev=root;
        solve(root->right);
    }
};
// first inversion-first node;
// last inversion-second node