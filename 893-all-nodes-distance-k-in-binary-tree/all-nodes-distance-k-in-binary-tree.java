/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> mp;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mp=new HashMap<>();
        build(root);
        List<Integer> ll=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> st=new HashSet<>();
        st.add(target);
        int level=0;
        while(!q.isEmpty()){
            int s=q.size();
            if(level==k){
                break;
            }
            level++;
            for(int i=0;i<s;i++){
                TreeNode r=q.poll();
                if(r.left!=null && !st.contains(r.left)){
                    st.add(r.left);
                    q.add(r.left);
                }
                if(r.right!=null && !st.contains(r.right)){
                    st.add(r.right);
                    q.add(r.right);
                }
                if(mp.containsKey(r) && !st.contains(mp.get(r))){
                    st.add(mp.get(r));
                    q.add(mp.get(r));
                }
            }
        }
        while(!q.isEmpty()){
            ll.add(q.poll().val);
        }
        return ll;
    }
    public void build(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode r=q.poll();
            if(r.left!=null){
                q.add(r.left);
                mp.put(r.left,r);
            }
            if(r.right!=null){
                q.add(r.right);
                mp.put(r.right,r);
            }
        }
    }
}