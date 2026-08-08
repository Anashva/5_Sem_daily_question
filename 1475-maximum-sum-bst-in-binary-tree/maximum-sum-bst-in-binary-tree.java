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
    class Pair{
        boolean bst=true;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        int sum=0;
        int ans=0;
    }
    public int maxSumBST(TreeNode root) {
        return solve(root).ans;
    }
    public Pair solve(TreeNode root){
        if(root==null){
            return new Pair();
        }
        Pair l=solve(root.left);
        Pair r=solve(root.right);
        Pair lr=new Pair();
        lr.min=Math.min(l.min,Math.min(root.val,r.min));
        lr.max=Math.max(l.max,Math.max(root.val,r.max));
        lr.sum=l.sum+r.sum+root.val;
        lr.ans=Math.max(r.ans,l.ans);
        lr.bst=l.bst && r.bst && l.max<root.val && r.min>root.val;
        if(lr.bst){
            lr.ans=Math.max(lr.ans,lr.sum);
        }
        return lr;
    }
}