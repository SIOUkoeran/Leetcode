class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        long result = 0;
        int idx = 0;
        while (idx < s.length() && isSpace(s.charAt(idx))){
            idx++;
        }
        if (idx < s.length()){
        if (s.charAt(idx) == '-' || s.charAt(idx) == '+'){
            if (s.charAt(idx) == '-'){
                sign *= -1;
            }
            idx++;
        }
        }
        while (idx < s.length() && isNumeric(s.charAt(idx))){
            result = result * 10 + sign * (s.charAt(idx) - '0') ;
            idx++;
            if (result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if (result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int) (result);
    }
    private static boolean isNumeric(char c){
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
    private static boolean isSpace(char c){
        if (c >= 9 && c <= 13)
            return true;
        if (c == ' ')
            return true;
        return false;
    }
}