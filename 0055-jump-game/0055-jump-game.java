class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int result = 0;
        int idx = 0;
        while (idx < nums.length && result < nums.length) {
            if (result < idx)
                break;
            result = Math.max(idx + nums[idx], result);
            ++idx;
        }
        return result >= nums.length - 1 ? true : false;
    }
}