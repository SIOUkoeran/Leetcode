class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int result = 0;
        int resultIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                result += sum;
                sum = 0;
                resultIdx = i + 1;
            }
        }
        result += sum;
        return result < 0 ? -1 : resultIdx;
    }
}