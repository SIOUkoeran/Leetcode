class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int idx = i, offset = 1, cnt = 0; idx < s.length(); idx += offset) {
                offset = 2 * (numRows - 1);
                if (i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(idx));
                } else {
                    offset = cnt % 2 != 0
                        ? 2 * i
                        : offset - (2 * i);
                    sb.append(s.charAt(idx));
                }
                ++cnt;
            }
        }
        return sb.toString();
    }
}