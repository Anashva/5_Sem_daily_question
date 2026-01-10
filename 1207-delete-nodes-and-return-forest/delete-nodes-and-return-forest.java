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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> st=new HashSet<>();
        for(int v:to_delete){
            st.add(v);
        }
        List<TreeNode> ans=new ArrayList<>();
        del(root,st,ans,true);
        return ans;
    }
    public TreeNode del(TreeNode root,HashSet<Integer> st,List<TreeNode> ans,boolean find){
        if(root==null){
            return null;
        }
        boolean check=false;
        if(st.contains(root.val)){
            check=true;
        }
        if(find && !check){
            ans.add(root);
        }
        root.left=del(root.left,st,ans,check);
        root.right=del(root.right,st,ans,check);
        return check ? null : root;
    }
}