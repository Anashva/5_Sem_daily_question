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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        inorder(root,ll);
        return sorted(ll,0,ll.size()-1);
    }
    public void inorder(TreeNode root,List<Integer> ll){
        if(root==null){
            return;
        }
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
    public TreeNode sorted(List<Integer> ll,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=(si+ei)/2;
        TreeNode root=new TreeNode(ll.get(mid));
        root.left=sorted(ll,si,mid-1);
        root.right=sorted(ll,mid+1,ei);
        return root;
    }
}