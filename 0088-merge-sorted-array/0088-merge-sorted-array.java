class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copyNums1 = copyArray(nums1, m);
        int idx1 = 0;
        int idx2 = 0;
        int i = 0;
        for (i = 0; i < m + n; i++) {
            if (idx1 >= m || idx2 >= n)
                break;
            if (copyNums1[idx1] > nums2[idx2])
                nums1[i] = nums2[idx2++];
            else 
                nums1[i] = copyNums1[idx1++];
        }
        System.out.println(Arrays.toString(nums1));
        if (idx1 < m){
            while (idx1 < m) {
                nums1[i++] = copyNums1[idx1++];
            }
        }
        if (idx2 < n) {
            while (idx2 < n) {
                nums1[i++] = nums2[idx2++];
            }
        }
            
   }
    
    private static int[] copyArray(int[] array, int length) {
        int[] copyNums1 = new int[length];
        for (int i = 0; i < length; i++) {
            copyNums1[i] = array[i];
        }
        return copyNums1;
    }
}