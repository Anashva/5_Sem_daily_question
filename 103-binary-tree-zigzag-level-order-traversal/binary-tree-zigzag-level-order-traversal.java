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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        levelorder(root,ans);
        return ans;
    }
    public void levelorder(TreeNode root,List<List<Integer>> ans){
        if(root==null){
            return;
        }
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean lefttoright=true;
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> ll = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(lefttoright){
                    TreeNode rv=q.pollFirst();//remove first and addlast
                    ll.add(rv.val);
                if(rv.left!=null){
                    q.addLast(rv.left);
                }
                if(rv.right!=null){
                    q.addLast(rv.right);
                }
                }
                else{
                TreeNode rv=q.pollLast();//remove last and add first
                ll.add(rv.val);
                if(rv.right!=null){
                q.addFirst(rv.right);
            }
                if(rv.left!=null){
                q.addFirst(rv.left);
            }
            }

            }
            lefttoright=!lefttoright;
            ans.add(ll);
        }
    }
}