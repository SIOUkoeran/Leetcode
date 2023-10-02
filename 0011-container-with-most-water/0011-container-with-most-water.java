class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left < right) {
            ans = Math.max(ans, calcArea(height, left, right));
            if (height[left] < height[right])
                ++left;
            else
                --right;
        }
        return ans;
    }
    
    // calculate amount of water
    private int calcArea(int[] height, int left, int right) {
        int h = Math.min(height[left], height[right]);
        return h * (right - left);
    }
}