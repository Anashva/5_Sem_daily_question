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
   unordered_map<int,int> mp;
    vector<int> findFrequentTreeSum(TreeNode* root) {
        count(root);
        vector<int> ans;
        int mx=0;
        for(auto &e: mp){
            mx=max(mx,e.second);
        }
        for(auto &e: mp){
            if(e.second==mx){
                ans.push_back(e.first);
            }
        }
        return ans;
    }
    int count(TreeNode* root){
        if(root==nullptr){
            return 0;
        }
        int sum=root->val+count(root->left)+count(root->right);
        mp[sum]++;
        return sum;
    }
};