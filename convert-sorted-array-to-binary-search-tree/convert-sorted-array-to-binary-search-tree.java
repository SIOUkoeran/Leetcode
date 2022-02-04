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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursiveSorted(nums, 0, nums.length - 1);
    }
    private static TreeNode recursiveSorted(int[] nums, int left, int right){
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        return new TreeNode(nums[mid], 
                           recursiveSorted(nums, left, mid - 1),
                           recursiveSorted(nums, mid + 1, right) 
                           );
        
    }
}