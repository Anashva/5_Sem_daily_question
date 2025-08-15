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
    int ans=Integer.MAX_VALUE;
    Integer prev=null;
    public int getMinimumDifference(TreeNode root) {
        diff(root);
        return ans;
    }
    public void diff(TreeNode root){
        if(root==null){
            return;
        }
        diff(root.left);
        if(prev!=null){
            ans=Math.min(ans,root.val-prev);
        }
        prev=root.val;
        diff(root.right);
    }
}