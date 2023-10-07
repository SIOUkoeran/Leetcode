class Solution {
    
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        Map<Character, Integer> dict = initDict(t);
        int left = 0, right = 0, ans = Integer.MAX_VALUE, leftAns = -1, rightAns = -1;
        if (dict.containsKey(s.charAt(0))) {
            dict.put(s.charAt(0), dict.get(s.charAt(0)) - 1);
        }
        while (right < s.length()) {
            boolean isAllContains = checkDictState(dict);
            if (isAllContains) {
                int gap = right - left;
                if (gap < ans) {
                    ans = gap;
                    leftAns = left;
                    rightAns = right;
                }
                if (dict.containsKey(s.charAt(left))) {
                    dict.put(s.charAt(left), dict.get(s.charAt(left)) + 1);
                }
                ++left;
            }else {
                ++right;
                if (right > s.length() - 1)
                    break;
                if (dict.containsKey(s.charAt(right))) {
                    dict.put(s.charAt(right), dict.get(s.charAt(right)) - 1);
                }
            }
        }
        if (leftAns == -1 || rightAns == -1)
            return "";
        return s.substring(leftAns, rightAns + 1);
    }
    
    private boolean checkDictState(Map<Character, Integer> dict) {
        for (Character key : dict.keySet()) {
            if (dict.get(key) > 0)
                return false;
        }
        return true;
    }
    
        
    private Map<Character, Integer> initDict(String t) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            putValIntoDict(dict, t.charAt(i));
        }
        return dict;
    }
    
    private void putValIntoDict(Map<Character, Integer> dict, Character c) {
        dict.put(c, dict.get(c) == null ? 1 : dict.get(c) + 1);
    }
    
   
}