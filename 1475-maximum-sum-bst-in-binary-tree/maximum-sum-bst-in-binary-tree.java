/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class bstpair{
        boolean isbst=true;
        Long max=Long.MIN_VALUE;
        Long min=Long.MAX_VALUE;
        int sum=0;
        int ans=0;//bst part sum only maximum
    }
    public int maxSumBST(TreeNode root) {
        return ValidBST(root).ans;
    }

    public bstpair ValidBST(TreeNode root){
        if(root==null){
            return new bstpair();
        }
        bstpair lbp=ValidBST(root.left);
        bstpair rbp=ValidBST(root.right);
        bstpair sbp=new bstpair();
        sbp.min=Math.min(lbp.min,Math.min(rbp.min,root.val));
        sbp.max=Math.max(lbp.max,Math.max(rbp.max,root.val));
        sbp.sum=lbp.sum + rbp.sum+ root.val;
        sbp.isbst=lbp.isbst && rbp.isbst && lbp.max<root.val && rbp.min>root.val;
        if(sbp.isbst){
            sbp.ans=Math.max(lbp.ans,Math.max(rbp.ans,sbp.sum));
        }
        else{
            sbp.ans=Math.max(lbp.ans,rbp.ans);
        }
        return sbp;
    }
}