class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);
    }
    private static int binarySearch(int low, int high, int key, int[] nums){
        if (low <= high){
            int mid = (low + high) / 2;
            if (key == nums[mid])
                return mid;
            else if (key > nums[mid]){
                return binarySearch(mid + 1, high, key, nums);
            }else if (key < nums[mid]){
                return binarySearch(low, mid - 1, key, nums);
            }
        }
        return -1;
    }
}