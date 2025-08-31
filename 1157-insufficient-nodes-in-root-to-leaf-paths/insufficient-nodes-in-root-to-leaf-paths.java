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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root,0,limit);
    }
    public TreeNode dfs(TreeNode root,int sum,int limit){
        if(root==null){
            return null;
        }
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum<limit){
                return null;
            }
            return root;
        }
        root.left=dfs(root.left,sum,limit);
        root.right=dfs(root.right,sum,limit);
        if(root.left==null && root.right==null){
            return null;
        }
        return root;
    }
}