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
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
        // int[] preindex={0};
        // return tree(preorder,inorder,0,preorder.length-1,preindex);
    // }
    // public TreeNode tree(int[] preorder,int[] inorder,int left,int right,int[]preindex){
    //     if(left>right){
    //         return null;
    //     }
    //     int rootval=preorder[preindex[0]];
    //     preindex[0]++;
    //     TreeNode root=new TreeNode(rootval);
    //     int index=search(inorder,left,right,rootval);

    //     root.left=tree(preorder,inorder,left,index-1,preindex);
    //     root.right=tree(preorder,inorder,index+1,right,preindex);

    //     return root;
    // }
    // public int search(int[] inorder,int left,int right,int val){
    //     for(int i=left;i<=right;i++){
    //         if(val==inorder[i]){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

// }


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
    }
    public TreeNode createTree(int[] in,int [] pre,int ilo,int ihi,int plo,int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode node=new TreeNode(pre[plo]);
        int idx=search(in,ilo,ihi,pre[plo]);
        int c=idx-ilo;
        node.left=createTree(in,pre,ilo,idx-1,plo+1,plo+c);
        node.right=createTree(in,pre,idx+1,ihi,plo+c+1,phi);
        return node;

    }
    public int search(int[]in,int ilo,int ihi,int item){
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==item){
                return i;
            }
        }
        return -1;
    }
}