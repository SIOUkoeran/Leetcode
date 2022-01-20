class Solution {
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i< nums.length; i++){
            linkedList.add(nums[i]);
        }
        while (k > 0){
            int temp = linkedList.pollLast();
            linkedList.addFirst(temp);
            k--;
        }
        for (int i = 0; i< nums.length; i++){
            nums[i] = linkedList.poll();
        }
    }
}