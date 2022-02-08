class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }
}