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
    public int sumEvenGrandparent(TreeNode root) {
        return sgp(root,-1,-1);
    }
    public int sgp(TreeNode root,int p,int gp){
        if(root==null){
            return 0;
        }
        int left=sgp(root.left,root.val,p);
        int right=sgp(root.right,root.val,p);
        if(gp%2!=0){
            return left+right;
        }
        else{
            return left+right+root.val;
        }
    }
}