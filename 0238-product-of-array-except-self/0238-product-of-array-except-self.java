class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length + 2];
        int[] backward = new int[nums.length + 2];
        Arrays.fill(forward, 1);
        Arrays.fill(backward, 1);
        
        for (int i = 2; i < nums.length + 1; i++) { 
            forward[i] = forward[i - 1]  * nums[i - 2];
            backward[nums.length - i + 1] = backward[nums.length - i + 2] * nums[nums.length + 1 - i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = forward[i + 1] * backward[i + 1];
            System.out.println(nums[i]);
        }
        return nums;
    }
}