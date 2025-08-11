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
    public int minimumOperations(TreeNode root) {
        return operation(root);
    }
    public int operation(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode rv=q.poll();
                ll.add(rv.val);
                if(rv.left!=null){
                    q.add(rv.left);
                }
                if(rv.right!=null){
                    q.add(rv.right);
                }
            }
            ans+=swap(ll);
        }
        return ans;
    }
    public int swap(List<Integer> ll){
        int c=0;
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<ll.size();i++){
            mp.put(ll.get(i),mp.getOrDefault(ll.get(i),i));
            ans.add(ll.get(i));
        }
        Collections.sort(ans);
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)!=ans.get(i)){
                int idx=i;
                int id=mp.get(ans.get(i));
                c++;
                Collections.swap(ll,idx,id);
                mp.put(ll.get(idx),idx);
                mp.put(ll.get(id),id);
            }
        }
        return c;
    }
}