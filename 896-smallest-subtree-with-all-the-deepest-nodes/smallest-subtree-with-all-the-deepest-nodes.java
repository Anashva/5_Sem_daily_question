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
        TreeNode node;
        int depth;
        Pair(TreeNode node,int depth){
            this.node=node;
            this.depth=depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root,0).node;
    }
    public Pair deep(TreeNode root,int depth){
        if(root==null){
            return new Pair(null,depth);
        }
        Pair left=deep(root.left,depth+1);
        Pair right=deep(root.right,depth+1);
        if(left.depth==right.depth){
            return new Pair(root,left.depth);
        }
         else if (left.depth < right.depth) {
            return right;
        } else {
            return left;
        }
    }
}