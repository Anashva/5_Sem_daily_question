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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        count(root);
        return  ans;
    }
    public Pair count(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair left=count(root.left);
        Pair right=count(root.right);
        int sum=left.sum+right.sum+root.val;
        int c=left.count+right.count+1;
        int avg=sum/c;
        if(root.val==avg){
            ans++;
        }
        return new Pair(sum,c);
    }
    class Pair{
        int sum;
        int count;
        Pair(int sum,int count){
            this.sum=sum;
            this.count=count;
        }
    }
}
