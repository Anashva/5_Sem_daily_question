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
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        List<Integer> ll = new ArrayList<>();
        inorder(root, ll);
        Collections.reverse(ll);
        int[] pre = new int[ll.size()];
        pre[0] = ll.get(0);
        for (int i = 1; i < ll.size(); i++) {
            pre[i] = pre[i - 1] + ll.get(i);
        }
        reverse(pre);

        assignValues(root, pre, new int[]{0});

        return root;
    }
    public void inorder(TreeNode root, List<Integer> ll) {
        if (root == null) return;
        inorder(root.left, ll);
        ll.add(root.val);
        inorder(root.right, ll);
    }
    public void assignValues(TreeNode root, int[] arr, int[] index) {
        if (root == null) return;
        assignValues(root.left, arr, index);
        root.val = arr[index[0]++];
        assignValues(root.right, arr, index);
    }

    public void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
