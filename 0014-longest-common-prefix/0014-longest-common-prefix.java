class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean isDone = false;
        while (!isDone && idx < (strs[0].length())) {
            char ch = strs[0].charAt(idx);
            for (int i = 1; i < strs.length; i++) {
                if (idx > strs[i].length() - 1) {
                    isDone = true;
                    break;
                }
                if (ch != strs[i].charAt(idx)) {
                    isDone = true;
                    break;
                }
            }
            if (!isDone)
                sb.append(ch);
            ++idx;
        }
        return sb.toString();
    }
}