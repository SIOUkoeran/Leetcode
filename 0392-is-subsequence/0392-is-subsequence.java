class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() == 0 && s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        int frontIdx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (frontIdx == s.length())
                return true;
            if (s.charAt(frontIdx) == t.charAt(i)) {
                ++frontIdx;
            }
        }
        return frontIdx == s.length() ? true : false;
    }
}