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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dl(root,0).node;
    }
    private Pair dl(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }

        Pair left = dl(root.left, depth + 1);
        Pair right = dl(root.right, depth + 1);

        if (left.depth == right.depth) {
            return new Pair(root, left.depth);
        } else if (left.depth < right.depth) {
            return right;
        } else {
            return left;
        }
    }
}