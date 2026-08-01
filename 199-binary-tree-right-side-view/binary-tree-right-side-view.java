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
    int max_depth=0;
    public List<Integer> rightSideView(TreeNode root) {
        // most frequent question aksed->krke jna hi hai
        List<Integer> ll=new ArrayList<>();
        // rightView(root,1,ll);
        right(root,ll);
        return ll;
         
    }
    public void rightView(TreeNode root,int curr_level,List<Integer> ll){
        if(root==null){
            return;
        }
        if(max_depth<curr_level){
            ll.add(root.val);
            max_depth=curr_level;
        }
        rightView(root.right,curr_level+1,ll);
        rightView(root.left,curr_level+1,ll);
    }
    public void right(TreeNode root,List<Integer> ll){
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode r=q.poll();
                if(i==s-1){
                    ll.add(r.val);
                }
                if(r.left!=null){
                    q.add(r.left);
                }
                if(r.right!=null){
                    q.add(r.right);
                }
            }
        }
    }
}
