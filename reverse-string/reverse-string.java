class Solution {
    public void reverseString(char[] s) {
        char temp;
        int length = s.length;
        for (int i = 0; i < length / 2; i++){
            temp = s[i];
            s[i] = s[length - 1 -i];
            s[length - 1 - i] = temp;
        }
    }
}