class Solution {
    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        int result = nums[0];
        int val = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                ++val;
            }else {
                if (val <= 0) {
                    result = nums[i];
                    val = 1;
                }
                --val;
            }
        }
        return result;
    }
}