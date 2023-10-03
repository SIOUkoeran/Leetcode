class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        StringBuilder sb = new StringBuilder();
        int lastIdx = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while (isConstains(s.charAt(i), sb)) {
                ++lastIdx;
                sb.deleteCharAt(0);
            }
            sb.append(s.charAt(i));
            ans = Math.max(ans, sb.length());
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
    
    private boolean isConstains(char c, StringBuilder sb) {
        for (int i = 0 ; i < sb.length(); i++) {
            if (sb.charAt(i) == c)
                return true;
        }
        return false;
    }
}