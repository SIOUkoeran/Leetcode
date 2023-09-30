class Solution {
    // 0 1 3 5 6
    // 0 1 2 3 4 4
    // 2 2 9 7
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int citation = citations[i];
            if (cnt < citation) {
                ++cnt;
            }
        }
        return cnt;
    }
}