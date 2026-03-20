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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> mp=new HashMap<>();
        List<TreeNode> ll=new ArrayList<>();
        serial(root,ll,mp);
        return ll;
    }
    public String serial(TreeNode root,List<TreeNode> ll,HashMap<String,Integer> mp){
        if(root==null){
            return "#";
        }
        String left=serial(root.left,ll,mp);
        String right=serial(root.right,ll,mp);
        String key=root.val+","+left+","+right;
        mp.put(key,mp.getOrDefault(key,0)+1);
        if(mp.get(key)==2){
            ll.add(root);
        }
        return key;
    }
}