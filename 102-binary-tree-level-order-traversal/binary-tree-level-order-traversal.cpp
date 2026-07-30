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
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == nullptr)
            return {};
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int s=q.size();
            vector<int> ll;
            while(s-->0){
                TreeNode* r=q.front();
                q.pop();
                ll.push_back(r->val);
                if(r->left!=nullptr){
                    q.push(r->left);
                }
                if(r->right!=nullptr){
                    q.push(r->right);
                }
            }
            ans.push_back(ll);
        }
        return ans;
    }
};