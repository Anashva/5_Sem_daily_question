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
    HashMap<Integer,Integer> mp;
    int pos=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        pos=postorder.length-1;
        return tree(inorder,postorder,0,postorder.length-1);
    }
    public TreeNode tree(int[] inorder,int[] postorder,int  left,int right){
        if(right<left){
            return null;
        }
        int val=postorder[pos];
        pos--;
        TreeNode root=new TreeNode(val);
        int idx=mp.get(val);
        root.right=tree(inorder,postorder,idx+1,right);   
        root.left=tree(inorder,postorder,left,idx-1);
        return root;
    }
}