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
    class Pair{
    public:
       bool bsp;
       long long max;
       long long min;
       Pair(){
        bsp=true;
        max=LLONG_MIN;
        min=LLONG_MAX;
       } 
    };
    bool isValidBST(TreeNode* root) {
        return bst(root).bsp;
    }
    Pair bst(TreeNode* root){
        if(root==nullptr){
            return Pair();
        }
        Pair l=bst(root->left);
        Pair r=bst(root->right);
        Pair rp;
        rp.min=min(l.min,min((long long)root->val,r.min));
        rp.max=max(l.max,max((long long)root->val,r.max));
        rp.bsp=l.bsp && r.bsp && (l.max<root->val) && (r.min>root->val);
        return rp;
    }
};