class Solution {
    //((numRows - 1) - i )* 2
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            int cnt = 0;
            for (int idx = i, offset = 1; idx < s.length(); idx += offset) {
                offset = 2 * (numRows - 1);
                // first
                if (i == 0) {
                    sb.append(s.charAt(idx));
                }
                // last
                else if (i == numRows - 1) {
                    sb.append(s.charAt(idx));
                }
                // general
                else {
                    if (cnt % 2 != 0) {
                        offset = (2 * i);
                        sb.append(s.charAt(idx));
                    }
                    else {
                        offset -= (2 * i); 
                        sb.append(s.charAt(idx));
                    }
                }
                ++cnt;
            }
        }
        return sb.toString();
    }
}