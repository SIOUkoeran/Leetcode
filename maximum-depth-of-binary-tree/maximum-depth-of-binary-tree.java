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
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        Stack<TreeDepth> stack = new Stack<>();
        stack.push(new TreeDepth(root, 1));
        TreeDepth tempNode;
        if (root == null)
            return 0;
        while(stack.size() > 0){
            tempNode = stack.pop();
            if (maxDepth < tempNode.depth)
                maxDepth = tempNode.depth;
            if (tempNode.node.right != null)
                stack.push(new TreeDepth(tempNode.node.right, tempNode.depth + 1));
            if (tempNode.node.left != null)
                stack.push(new TreeDepth(tempNode.node.left, tempNode.depth + 1));
            
        }
        return maxDepth;
        
    }
        private static class TreeDepth{
        TreeNode node;
        int depth;
        public TreeDepth(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
