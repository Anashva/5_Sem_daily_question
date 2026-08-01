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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            Pair start=q.peek();
            Pair end=null;
            int s=q.size();
            for(int i=0;i<s;i++){
                end=q.poll();
                if(end.node.left!=null){
                    q.add(new Pair(end.node.left,2*end.idx+1));
                }
                if(end.node.right!=null){
                    q.add(new Pair(end.node.right,2*end.idx+2));
                }
            }
            ans=Math.max(ans,end.idx-start.idx+1);
        }
        return ans;
    }
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
}