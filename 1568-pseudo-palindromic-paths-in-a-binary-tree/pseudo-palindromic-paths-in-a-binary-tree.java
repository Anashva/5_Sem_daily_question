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
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null){
            return 0;
        }
        HashMap<Integer,Integer> mp=new HashMap<>();
        dfs(root,mp);
        return ans;
    }
    public void dfs(TreeNode root,HashMap<Integer,Integer> mp){
        if(root==null){
            return;
        }
        mp.put(root.val,mp.getOrDefault(root.val,0)+1);
        if(root.left==null && root.right==null){
            if(pallindrome(mp)){
                ans++;
            }
        }
        dfs(root.left,mp);
        dfs(root.right,mp);

        mp.put(root.val,mp.get(root.val)-1);

    }
    public boolean pallindrome(HashMap<Integer,Integer> mp){
        int c=0;
        for(int k:mp.values()){
            if(k%2==1){
                c++;
            }
        }
        return c<2;
    }

}