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
    public int maxLevelSum(TreeNode root) {
        return levelorder(root);
    }
    public int levelorder(TreeNode root){
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        int minlevel=1;
        int level=1;
        int maxsum=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for(int i=0;i<n;i++){
                TreeNode rv=q.remove();
                sum+=rv.val;
            if(rv.left!=null){
                q.add(rv.left);
            }
            if(rv.right!=null){
                q.add(rv.right);
            }
            }
            if(sum>maxsum){
                maxsum=sum;
                minlevel=level;
            }
            level++;
        }
        return minlevel;
    }
}