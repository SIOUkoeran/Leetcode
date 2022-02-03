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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tempNode = root;
        Integer value = null;
        while(!stack.isEmpty() || tempNode != null){
            while (tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            if (value != null && value >= tempNode.val){
                return false;
            }
            value = tempNode.val;
            
            tempNode = tempNode.right;
        }
        return true;
    }
}