class Solution {
    public int removeDuplicates(int[] nums) {
        int isDuplicate = 1;
        int idx = 0;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] && isDuplicate < 2) {
                nums[++idx] = nums[i];
                ++isDuplicate;
                ++cnt;
            }
            else if (nums[i - 1] != nums[i]) {
                isDuplicate = 1;
                nums[++idx] = nums[i];
                ++cnt;
            }
            else ++isDuplicate;
        }
        return cnt;
    }
}