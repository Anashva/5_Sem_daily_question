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
    public long kthLargestLevelSum(TreeNode root, int k) {
        return largest(root,k);
    }
    public long largest(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> pq=new LinkedList<>();
        List<Long> ll=new ArrayList<>();
        pq.add(root);
        while(!pq.isEmpty()){
            int n=pq.size();
            long sum=0;
            for(int i=0;i<n;i++){
                TreeNode rv=pq.remove();
                sum+=rv.val;
                if(rv.left!=null){
                    pq.add(rv.left);
                }
                if(rv.right!=null){
                    pq.add(rv.right);
                }
            }
            ll.add(sum);
        }
        if(ll.size()<k){
            return -1;
        }
        Collections.sort(ll, Collections.reverseOrder());

        return ll.get(k - 1);
    }
}