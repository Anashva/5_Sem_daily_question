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
    static int idx=0;
    public TreeNode recoverFromPreorder(String traversal) {
        idx=0;
        return pre(traversal,0);
    }
    public TreeNode pre(String s,int d){
        if(idx>=s.length()){
            return null;
        }
        int j=0;
        while((j+idx)<s.length() && s.charAt(idx+j)=='-'){
            j++;
        }
        if(j!=d){
            return null;
        }
        int n=0;
        idx+=j;
        while(idx<s.length() && Character.isDigit(s.charAt(idx))){
            n=n*10+(s.charAt(idx)-'0');
            idx++;
        }
        TreeNode root=new TreeNode(n);
        root.left=pre(s,d+1);
        root.right=pre(s,d+1);
        return root;
    }
}