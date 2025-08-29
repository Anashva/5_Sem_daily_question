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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftmax=max(root.left);
        int leftmin=min(root.left);
        int rightmax=max(root.right);
        int rightmin=min(root.right);

        int maxleft=0;
        if(root.left!=null){
            maxleft=Math.max(Math.abs(root.val-leftmax),Math.abs(root.val-leftmin));
        }
        int maxright=0;
        if(root.right!=null){
           maxright= Math.max(Math.abs(root.val-rightmax),Math.abs(root.val-rightmin));
        }
        int leftAns = maxAncestorDiff(root.left);
        int rightAns = maxAncestorDiff(root.right);
        return Math.max(Math.max(maxleft, maxright), Math.max(leftAns, rightAns));
    }
    public int max(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int left=max(root.left);
        int right=max(root.right);
        return Math.max(Math.max(left,right),root.val);
    }
    public int min(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int left=min(root.left);
        int right=min(root.right);
        return Math.min(root.val,Math.min(left,right));
    }
}