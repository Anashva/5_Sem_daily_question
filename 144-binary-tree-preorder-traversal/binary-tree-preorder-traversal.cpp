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
    vector<int> ll;
    vector<int> preorderTraversal(TreeNode* root) {
        // pre(root);
        if(root == nullptr)
            return ll;
        stack<TreeNode*> st;
        st.push(root);
        while(!st.empty()){
            TreeNode* r = st.top();
            st.pop();
            ll.push_back(r->val);
            if(r->right){
                st.push(r->right);
            }
            if(r->left){
                st.push(r->left);
            }
        }
        return ll;
    }
    void pre(TreeNode* root){
        if(root==nullptr){
            return;
        }
        ll.push_back(root->val);
        pre(root->left);
        pre(root->right);
    }
};