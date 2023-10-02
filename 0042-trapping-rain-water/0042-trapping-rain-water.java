class Solution {
    public int trap(int[] height) {
        int result = 0;
        int preWall = height[0];
        int[] water = new int[height.length];
        
        int prevWall = height[0];
        //pour water
        for (int i = 1; i < height.length; i++) {
            if (prevWall < height[i]) {
                prevWall = height[i];
            }
            if (height[i] < prevWall) {
                result += prevWall - height[i];
                water[i] = prevWall - height[i];
            }
        }
        prevWall = height[height.length - 1];
        
        //drain water
        for (int i = height.length - 1; i >= 0; i--) {
            if (prevWall < height[i]) {
                prevWall = height[i];
            }
            if (height[i] + water[i] > prevWall) {
                result -= (height[i] + water[i]) - prevWall;
            }
        }
        return result;
    }
}