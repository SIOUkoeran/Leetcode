class Solution {
    public int reverse(int x) {
        long result = 0;
        int sign = 1;
        if (x < 0){
            sign = -1;
            x *= -1;
        }
        while (x > 0){
            result = result * 10 + x % 10 * sign;
            x /= 10;
            if (result > (long) Math.pow(2, 31) - 1 || result < (long) Math.pow(2, 31) * -1){
                return 0;
            }
        }
        return (int) result;
    }
}