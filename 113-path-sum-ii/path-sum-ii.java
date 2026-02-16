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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> ll=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        sum(root,targetSum,ll,ans);
        return ans;
    }
    public void sum(TreeNode root,int target,List<Integer> ll,List<List<Integer>> ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(target-root.val==0){
                ll.add(root.val);
                ans.add(new ArrayList<>(ll));
                ll.remove(ll.size()-1);
            }
            return;
        }
        ll.add(root.val);
        sum(root.left,target-root.val,ll,ans);
        sum(root.right,target-root.val,ll,ans);
        ll.remove(ll.size()-1);
    }
}