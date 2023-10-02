class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int startIdx = 0;
        int endIdx = numbers.length - 1;
        while (startIdx < endIdx){
            int sum = numbers[startIdx] + numbers[endIdx];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                --endIdx;
            }
            else if (sum < target) {
                ++startIdx;
            }
        }
        return new int[]{startIdx + 1, endIdx + 1};
    }
}