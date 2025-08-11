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
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> st=new HashSet<>();
        val(root,st);
        int fmin=root.val;
        Long smin=Long.MAX_VALUE;
        boolean found = false;

        for (int v : st) {
            long k=(long)v;
            if (v > fmin && (!found ||k < smin)) {
                smin = k;
                found = true;
            }
        }
        return found ? (int) (long)smin : -1;

    }
    public void val(TreeNode root,HashSet<Integer> st){
        if(root==null){
            return;
        }
        st.add(root.val);
        val(root.left, st);
        val(root.right, st);
    }
}