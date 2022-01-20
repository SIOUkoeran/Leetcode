class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] resultNums = Arrays.stream(nums).distinct().toArray();
        for (int i = 0; i < resultNums.length; i++){
            nums[i] = resultNums[i];
        }
        return resultNums.length;
    }
}