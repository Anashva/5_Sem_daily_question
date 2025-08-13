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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.add(root);
        boolean flag=false;
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode rv=q.poll();
                ll.add(rv.val);
                if(rv.left!=null){
                    q.add(rv.left);
                }
                if(rv.right!=null){
                    q.add(rv.right);
                }
            }
            if(flag){
                Collections.reverse(ll);
            }
            ans.add(ll);
            flag=!flag;
        }
        return buildTree(ans);
    }
    public static TreeNode buildTree(List<List<Integer>> levels) {
        if (levels == null || levels.isEmpty() || levels.get(0).isEmpty())
            return null;

        TreeNode root = new TreeNode(levels.get(0).get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < levels.size(); i++) {
            List<Integer> currentLevel = levels.get(i);
            Queue<TreeNode> nextQueue = new LinkedList<>();

            int index = 0;
            while (!queue.isEmpty() && index < currentLevel.size()) {
                TreeNode parent = queue.poll();

                Integer leftVal = currentLevel.get(index++);
                if (leftVal != null) {
                    parent.left = new TreeNode(leftVal);
                    nextQueue.offer(parent.left);
                }
                if (index < currentLevel.size()) {
                    Integer rightVal = currentLevel.get(index++);
                    if (rightVal != null) {
                        parent.right = new TreeNode(rightVal);
                        nextQueue.offer(parent.right);
                    }
                }
            }
            queue = nextQueue;
        }
        return root;
    }
}