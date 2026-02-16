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
        boolean bsp=true;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root).bsp;
    }
    public pair validate(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair l=validate(root.left);
        pair r=validate(root.right);
        pair lr=new pair();
        lr.min=Math.min(l.min,Math.min(root.val,r.min));
        lr.max=Math.max(l.max,Math.max(root.val,r.max));
        lr.bsp=l.bsp && r.bsp && l.max<root.val && r.min>root.val;
        return lr;
    }
}