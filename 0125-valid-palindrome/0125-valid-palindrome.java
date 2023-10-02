class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append((char) (s.charAt(i) - 'A' + 'a'));
            }
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() == 1)
            return true;
        int right = sb.length() - 1;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(right) != sb.charAt(i))
                return false;
            --right;
        }
        return true;
    }
}