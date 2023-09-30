class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int result = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prev == -1 || prev > prices[i])
                prev = prices[i];
            if (prev < prices[i]) {
                result += prices[i] - prev;
                prev = prices[i];
            }
        }
        return result;
    }
}