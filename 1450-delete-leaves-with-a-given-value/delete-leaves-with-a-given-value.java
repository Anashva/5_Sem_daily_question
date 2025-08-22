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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return remove(root,target);
    }
    public TreeNode remove(TreeNode root,int val){
        if(root==null){
            return null;
        }
        root.left=remove(root.left,val);
        root.right=remove(root.right,val);

        if(root.left==null && root.right==null && root.val==val){
            return null;
        }
        
        return root;

    }
}