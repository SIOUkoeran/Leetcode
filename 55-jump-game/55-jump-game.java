class Solution {
    public boolean canJump(int[] nums) {
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1)
            return true;
        for (int i = 1; i < nums.length - 1; i++){
            if (dp[i - 1] == 0)
                break;
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            
        }
        if (dp[nums.length - 2] == 0)
            return false;
        return true;
    }
}