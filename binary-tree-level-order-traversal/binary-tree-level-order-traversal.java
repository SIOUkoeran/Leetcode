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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        List<List<Integer>> returnList = new LinkedList<>();
        if (root == null)
            return returnList;
        List<Integer> tempList;
        TreeNode tempNode;
        q.add(root);
        while (!q.isEmpty()){
            tempList = new LinkedList<>();
            while (!q.isEmpty()){
                tempNode = q.poll();
                tempList.add(tempNode.val);
                if (tempNode.left != null){
                    treeNodeList.add(tempNode.left);
                }
                if (tempNode.right != null){
                    treeNodeList.add(tempNode.right);
                }
            }
            returnList.add(tempList);
            while (!treeNodeList.isEmpty())
                q.add(treeNodeList.poll());
        }
        return returnList;
    }
}