class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1)
            return;
        if (nums.length <= k)
            k = k % nums.length;
        int[] tempArray = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            tempArray[-nums.length + k + i] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempArray[i];
        }
    }
}