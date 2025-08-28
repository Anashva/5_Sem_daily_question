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
    class VP{
        TreeNode node;
        int l;//row
        int v;//col
        public VP(TreeNode node,int l,int v){
            this.l=l;
            this.v=v;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<VP> q=new LinkedList<>();
        q.add(new VP(root,0,0));
        TreeMap<Integer,List<VP>> mp=new TreeMap<>();
        while(!q.isEmpty()){
            VP vp=q.poll();
            if(!mp.containsKey(vp.v)){
                mp.put(vp.v,new ArrayList<>());
            }
            mp.get(vp.v).add(vp);
            if(vp.node.left!=null){
                q.add(new VP(vp.node.left,vp.l+1,vp.v-1));
            }
            if(vp.node.right!=null){
                q.add(new VP(vp.node.right,vp.l+1,vp.v+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int key:mp.keySet()){
            List<VP> ll=mp.get(key);
            Collections.sort(ll,new Comparator<VP>(){
                @Override
                public int compare(VP o1,VP o2){
                    if(o1.l==o2.l){
                        return o1.node.val-o2.node.val;
                    }
                    return 0;
                }
            });
            List<Integer> ls=new ArrayList<>();
            for(VP v:ll){
                ls.add(v.node.val);
            }
            ans.add(ls);
        }
        return ans;
    }
}