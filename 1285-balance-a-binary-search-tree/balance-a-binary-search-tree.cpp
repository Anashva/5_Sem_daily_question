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
    TreeNode* sorted(vector<int> &ll,int si,int ei){
        if(si>ei){
            return nullptr;
        }
        int mid=(si+ei)/2;
        TreeNode* root=new TreeNode(ll[mid]);
        root->left=sorted(ll,si,mid-1);
        root->right=sorted(ll,mid+1,ei);
        return root;
    }
    void inorder(TreeNode* root,vector<int> &ll){
        if(root==nullptr){
            return;
        }
        inorder(root->left,ll);
        ll.push_back(root->val);
        inorder(root->right,ll);

    }
    TreeNode* balanceBST(TreeNode* root) {
        vector<int> ll;
        inorder(root,ll);
        return sorted(ll,0,ll.size()-1);
    }
};