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
    int pre=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return tree(preorder,0,preorder.length-1);
    }
    public TreeNode tree(int[] preo,int si,int ei){
        if(si>ei){
            return null;
        }
        int val=preo[pre++];
        TreeNode root=new TreeNode(val);
        int idx=mp.get(val);
        root.left=tree(preo,si,idx-1);
        root.right=tree(preo,idx+1,ei);
        return root;
    }
}