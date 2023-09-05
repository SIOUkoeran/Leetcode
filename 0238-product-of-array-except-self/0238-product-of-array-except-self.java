class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outputNums = new int[nums.length];
        int[] postCalc = new int[nums.length];
        int[] preCalc = new int[nums.length];
        preCalc[0] = 1;
        postCalc[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            preCalc[i] = preCalc[i - 1] * nums[i - 1];
            postCalc[nums.length - 1 - i] = nums[nums.length - i] * postCalc[nums.length -i];
         }
        for (int i = 0; i < nums.length; i++) {
            outputNums[i] = preCalc[i] * postCalc[i];
        }
        return outputNums;
        }
}