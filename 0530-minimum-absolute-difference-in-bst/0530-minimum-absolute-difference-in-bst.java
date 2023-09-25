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
    List<Integer> sortedValue = new LinkedList<Integer>();
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        inOrder(root);
        for (int i = 1; i < sortedValue.size(); i++) {
            result = Math.min(result, sortedValue.get(i) - sortedValue.get(i - 1));
        }
        return result;
    }
    
    private void inOrder(TreeNode node) {
        if (node != null) {
            if (node.left != null)
                inOrder(node.left);
            sortedValue.add(node.val);
            if (node.right != null)
                inOrder(node.right);    
        }
        
    }
}