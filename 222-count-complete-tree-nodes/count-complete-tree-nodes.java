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
    public int countNodes(TreeNode root) {
        // return count(root);
        if(root==null){
            return 0;
        }
        int l=left(root);
        int r=right(root);
        if(r==l){
            return (1<<r)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int left(TreeNode r){
        int h=0;
        while(r!=null){
            h++;
            r=r.left;
        }
        return h;
    }
    public int right(TreeNode r){
        int h=0;
        while(r!=null){
            h++;
            r=r.right;
        }
        return h;
    }
    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=count(root.left);
        int r=count(root.right);
        return l+r+1;
    }
}