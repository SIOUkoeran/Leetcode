class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (true){
            if (i == nums1.length || j == nums2.length){
                break;
            }
            if (nums1[i] == nums2[j]){
                arrayList.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] result = new int[arrayList.size()];
        for (int k = 0; k < arrayList.size(); k++) {
            result[k] = arrayList.get(k);
        }
        return result;
    }
}