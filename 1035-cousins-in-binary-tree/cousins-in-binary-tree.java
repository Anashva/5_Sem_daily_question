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
    TreeNode xparent=null;
    TreeNode yparent=null;
    int xd=0;
    int yd=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        xd=0;
        yd=0;
        cousin(root,root,0,x,y);
        return (xd==yd) && (xparent!=yparent);
    }
    public void cousin(TreeNode root,TreeNode parent,int d,int x,int y){
        if(root==null){
            return;
        }
        if(root.val==x){
            xparent=parent;
            xd=d;
        }
        else if(root.val==y){
            yparent=parent;
            yd=d;
        }
        cousin(root.left,root,d+1,x,y);
        cousin(root.right,root,d+1,x,y);
    }
}