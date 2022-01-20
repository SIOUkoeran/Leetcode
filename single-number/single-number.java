class Solution {
    public int singleNumber(int[] nums) {
        
        for (int i = 0; i < nums.length; i++){
            boolean flag = false;
            for (int j = 0; j < nums.length; j++){
                if (i != j && nums[i] == nums[j]){
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                return nums[i];
            }
    }
    return 0;
}
}