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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        dfs(root1,l1);
        dfs(root2,l2);
        l1.addAll(l2);
        Collections.sort(l1);
        return l1;

    }
    public void dfs(TreeNode root,List<Integer> ll){
        if(root==null){
            return;
        }
        ll.add(root.val);
        dfs(root.left,ll);
        dfs(root.right,ll);
    }
}