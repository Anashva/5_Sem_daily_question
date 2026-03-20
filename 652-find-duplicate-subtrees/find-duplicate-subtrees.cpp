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
    unordered_map<string,int> mp;
    vector<TreeNode*> ll;
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        dfs(root);
        return ll;
    }
    string dfs(TreeNode* root){
        if(!root){
            return "#";
        }
        string left=dfs(root->left);
        string right=dfs(root->right);
        string key=to_string(root->val)+","+left+","+right;
        mp[key]++;
        if(mp[key]==2){
            ll.push_back(root);
        }
        return key;
    }
};