class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            if (sum >= target) {
                while (sum >= target) {
                    ans = Math.min(ans, right - left);
                    sum -= nums[left++];
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}