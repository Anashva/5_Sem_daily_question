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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trim(root,low,high);
    }
    public TreeNode trim(TreeNode root,int low,int high){
        if(root==null){
            return null;
        }
        if(root.val<low){
            return trim(root.right,low,high);
        }
        if(root.val>high){
            return trim(root.left,low,high);
        }
        root.left=trim(root.left,low,high);
        root.right=trim(root.right,low,high);
        return root;
    }
}