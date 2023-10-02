class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() == 0 && s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;
        int frontIdx = 0;
        int backIdx = s.length() - 1;
        for (int i = 0; i < t.length() / 2 + 1; i++) {
            System.out.println("frontIdx " + frontIdx + " backIdx " + backIdx);
            if (frontIdx > backIdx)
                return true;
            if (s.charAt(frontIdx) == t.charAt(i)) {
                ++frontIdx;
            }
            if (s.charAt(backIdx) == t.charAt(t.length() - 1 - i)) {
                --backIdx;
            }
        }
        return frontIdx == s.length() ? true : false;
    }
}