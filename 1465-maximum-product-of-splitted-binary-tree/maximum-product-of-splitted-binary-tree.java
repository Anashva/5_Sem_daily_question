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
    long tsum=0;
    long p=0;
    int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        totalsum(root);
        product(root);
        return (int)(p%MOD) ;
    }
    public long product(TreeNode root){
        if(root==null){
            return 0;
        }
        long sum=root.val+product(root.left)+product(root.right);
        long prod=sum*(tsum-sum);
        p=Math.max(p,prod);
        return sum;
    }
    public void totalsum(TreeNode root){
        if(root==null){
            return ;
        }
        tsum+=root.val;
        totalsum(root.left);
        totalsum(root.right);
    }
}