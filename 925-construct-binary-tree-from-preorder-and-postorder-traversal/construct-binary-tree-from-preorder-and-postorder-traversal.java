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
    int pre=0;
    int pos=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return preo(preorder, postorder);
    }
    public TreeNode preo(int[] preorder,int[] postorder){

        TreeNode root=new TreeNode(preorder[pre++]);
        if(root.val!=postorder[pos]){
            root.left=preo(preorder,postorder);
        }
        if(root.val!=postorder[pos]){
            root.right=preo(preorder,postorder);
        }
        pos++;
        return root;

    }
}