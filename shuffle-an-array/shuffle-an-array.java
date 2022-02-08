class Solution {
    int[] original = null;
    int[] returnNums = null;
    Random random = null;
    public Solution(int[] nums) {
        this.original = nums;
        this.returnNums = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }
    
    public int[] reset() {
        
        return original;
    }
    
    public int[] shuffle() {
        int tmp = 0;
        int x = 0;
        int idx = 0;
        for (int i = 0; i < returnNums.length; i++){
            x = random.nextInt(returnNums.length - i);
            idx = x + i;
            tmp = returnNums[idx];
            returnNums[idx] = returnNums[i];
            returnNums[i] = tmp;
        }
        return returnNums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */