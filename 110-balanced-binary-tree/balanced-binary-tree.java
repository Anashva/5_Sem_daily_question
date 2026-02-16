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
    class pair{
        boolean isbalance=true;
        int ht=-1;
    }
    public boolean isBalanced(TreeNode root) {
        return balance(root).isbalance;
    }
    public pair balance(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair left=balance(root.left);
        pair right=balance(root.right);
        pair plr=new pair();
        plr.ht=1+Math.max(left.ht,right.ht);
        plr.isbalance=left.isbalance && right.isbalance && Math.abs(left.ht-right.ht)<=1;
        return plr;
    }
}