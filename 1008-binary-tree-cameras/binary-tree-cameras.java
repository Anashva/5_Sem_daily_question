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
    // need camera=-1
    // has camera=1
    // cover camera=0 
    int camera=0;
    public int minCameraCover(TreeNode root) {
        int c=minCamera(root);
        if(c==-1){
            camera++;
        }
        return camera;
    }
    public int minCamera(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=minCamera(root.left);
        int right=minCamera(root.right);
        if(left ==-1 || right==-1){//is node pr camera ki required hai
            camera++;
            return 1;//camera setup kara h is node par
        }
        else if(left==1 || right==1){// inme se koi ek paas ya dono k paas camera hai orek pass camera hai and  dusra wala covered hai
           return 0;
            
        }
        else{
            return -1;//need camera
        }
    }
}