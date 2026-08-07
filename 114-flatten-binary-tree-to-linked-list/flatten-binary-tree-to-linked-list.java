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
    List<TreeNode> ll=new ArrayList<>();
    public void flatten(TreeNode root) {
        node(root);
        for(int i=1;i<ll.size();i++){
            TreeNode prev=ll.get(i-1);
            TreeNode curr=ll.get(i);
            prev.left=null;
            prev.right=curr;
        }
        // make(root);
    }
    public void node(TreeNode r){
        if(r==null){
            return;
        }
        ll.add(r);
        node(r.left);
        node(r.right);
    }
    public TreeNode make(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        TreeNode left_tail=make(root.left);
        TreeNode right_tail=make(root.right);
        if(root.left!=null){
            left_tail.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        return right_tail!=null ? right_tail :left_tail;
    }
}