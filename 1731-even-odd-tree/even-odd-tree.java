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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> pq=new LinkedList<>();
        pq.add(root);
        boolean flag=true;
        while(!pq.isEmpty()){
            int len=pq.size();
            ArrayList<Integer> ll=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode rv=pq.poll();
                ll.add(rv.val);
                if(rv.left!=null){
                    pq.add(rv.left);
                }
                if(rv.right!=null){
                    pq.add(rv.right);
                }
            }
            if(flag && !odd(ll)){
                return false;
            }
            else if(!flag && !even(ll)){
                return false;
            }
            flag=!flag;
        }
        return true;
    }
    public boolean odd(ArrayList<Integer>ll){
        int prev=Integer.MIN_VALUE;
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)%2==0){
                return false;
            }
            if(ll.get(i)<=prev){
                return false;
            }
            prev=ll.get(i);
        }
        return true;
    }
    public boolean even(ArrayList<Integer>ll){
        int prev=Integer.MAX_VALUE;
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)%2!=0){
                return false;
            }
            if(prev<=ll.get(i)){
                return false;
            }
            prev=ll.get(i);
        }
        return true;
    }
}