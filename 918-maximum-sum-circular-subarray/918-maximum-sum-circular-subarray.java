class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int dp1 = 0;
        int dp2 = 0;
        int max = -987654321;
        int min = 987654321;
        for (int i = 0; i < nums.length; i++){
            dp1 += nums[i];
            max = Math.max(dp1, max);
            dp1 = Math.max(0, dp1);
            
            dp2 += nums[i];
            min = Math.min(dp2, min);
            dp2 = Math.min(0, dp2);
            
            sum += nums[i];
        }
        if (max > 0)
            return Math.max(sum - min, max);
        return max;
    }
}