class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int idx = 0;
            if (haystack.charAt(i) == needle.charAt(idx)) {
                if (isPerfectMatch(i, haystack, needle))
                    return i;
            }
        }
        return -1;
    }
    
    private boolean isPerfectMatch(int idx, String haystack, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (idx > haystack.length() - 1) {
                return false;
            }
            if (needle.charAt(i) != haystack.charAt(idx++)){
                return false;
            }
        }
        return true;
    }
}