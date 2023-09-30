class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int profit = Integer.MIN_VALUE;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prev > prices[i]){
                prev = prices[i];
            }
            if (prices[i] - prev > profit) {
                profit = prices[i] - prev;
            }
        }
        return profit;
    }
}