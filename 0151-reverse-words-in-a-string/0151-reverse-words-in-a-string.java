class Solution {
    private StringBuilder sb;
    public String reverseWords(String s) {
        String trimedString = s.trim();
        sb = new StringBuilder();
        int i = trimedString.length() - 1;
        int lastIdx = trimedString.length() - 1;
        for (i = trimedString.length() - 1; i >= 0; i--) {
            if (trimedString.charAt(i) == ' ' && trimedString.charAt(i + 1) != ' ') {
                reverseString(i, lastIdx, trimedString);
                lastIdx = i - 1;
            }
            else if (trimedString.charAt(i) == ' ' && trimedString.charAt(i + 1) == ' ') {
                lastIdx = i - 1;          
            }
            if (i == 0) {
                reverseString(i - 1, lastIdx, trimedString);
            }
        }
        return sb.toString().trim();
    }
    
    private void reverseString(int startIdx, int lastIdx, String s) {
        System.out.println("s " + startIdx + " l " + lastIdx);
        System.out.println("l" + s.substring(startIdx + 1, lastIdx + 1) + "l");
        sb.append(s.substring(startIdx + 1, lastIdx + 1));
        sb.append(" ");
    }
}