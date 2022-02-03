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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        TreeNode tempNode1;
        TreeNode tempNode2;
        while (!q.isEmpty()){
            tempNode1 = q.poll();
            tempNode2 = q.poll();
            if (tempNode1 == null && tempNode2 == null)
                continue;
            if (tempNode1 != null && tempNode2 == null)
                return false;
            if (tempNode1 == null && tempNode2 != null)
                return false;
            if (tempNode1.val != tempNode2.val)
                return false;
            q.add(tempNode1.left);
            q.add(tempNode2.right);
            q.add(tempNode1.right);
            q.add(tempNode2.left);
        }
        return true;
        
    }
}