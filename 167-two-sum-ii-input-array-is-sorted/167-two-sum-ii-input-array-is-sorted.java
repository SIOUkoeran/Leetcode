class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int sum = 0;
        int[] returnInt = new int[2];
        while (low <= high){
            sum = numbers[low] + numbers[high];
            if (sum == target){
                returnInt[0] = low + 1;
                returnInt[1] = high + 1;
                break;
            }else if (sum > target){
                high--;
            }else{
                low++;
            }
        }
        return returnInt;
    }
}
