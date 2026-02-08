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
    class Balancepair{
        boolean isbal=true;
        int ht=-1;

    }
    public boolean isBalanced(TreeNode root) {
        return balance(root).isbal;
    }
    public Balancepair balance(TreeNode root){
        if(root==null){
            return new Balancepair();
        }
        Balancepair lbp=balance(root.left);
        Balancepair rbp=balance(root.right);
        Balancepair sbp=new Balancepair();
        sbp.ht=Math.max(lbp.ht,rbp.ht)+1;
        boolean sb=Math.abs(lbp.ht-rbp.ht)<=1;
        sbp.isbal=lbp.isbal && rbp.isbal && sb;
        return sbp;
    }
}