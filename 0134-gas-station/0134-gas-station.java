class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int costTotal = 0;
        int total = 0;
        int startIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            costTotal += gas[i] - cost[i];
            if (costTotal < 0) {
                total += costTotal;
                costTotal = 0;
                startIdx = i + 1 > gas.length ? -1 : i + 1;
            }
        }
        if (costTotal > 0)
            total += costTotal;
        return total >= 0 ? startIdx : -1;
    }
}