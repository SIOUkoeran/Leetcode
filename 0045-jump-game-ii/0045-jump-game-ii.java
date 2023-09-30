class Solution {
    public int jump(int[] nums) {
        int distance = 0;
        int curIdx = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            
            if (curIdx < i) {
                curIdx = distance;
                ++ans;
            }
            distance = Math.max(distance, nums[i] + i);
        }
        return ans;
    }
}