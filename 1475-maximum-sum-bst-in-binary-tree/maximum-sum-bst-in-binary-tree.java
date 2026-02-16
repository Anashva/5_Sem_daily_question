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
        boolean bst=true;
        Integer min=Integer.MAX_VALUE;
        Integer max=Integer.MIN_VALUE;
        int sum=0;
        int ans=0;
    }
    public int maxSumBST(TreeNode root) {
        return Sum(root).ans;
    }
    public pair Sum(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair l=Sum(root.left);
        pair r=Sum(root.right);
        pair lr=new pair();
        lr.min=Math.min(l.min,Math.min(root.val,r.min));
        lr.max=Math.max(l.max,Math.max(root.val,r.max));
        lr.sum=l.sum+r.sum+root.val;
        lr.bst=l.bst && r.bst && l.max<root.val && r.min>root.val;
        if(lr.bst){
            lr.ans=Math.max(l.ans,Math.max(r.ans,lr.sum));
        }
        else{
            lr.ans=Math.max(l.ans,r.ans);
        }
        return lr;
    }
}