class Solution {
    public int[] sortedSquares(int[] nums) {
        heapSort(nums);
        return nums;
    }
    private static void heapSort(int[] nums){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            q.add(nums[i] * nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = q.poll();
        }
    }
}