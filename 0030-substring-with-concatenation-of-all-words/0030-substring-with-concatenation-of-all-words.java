class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dict = initDict(words);
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String possibleString = s.substring(i, totalLength + i);
            int startIdx = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();
            while (startIdx < totalLength) {
                String w = possibleString.substring(startIdx, startIdx + wordLength);
                if (map.containsKey(w))
                    map.put(w, map.get(w) + 1);
                else
                    map.put(w, 1);
                startIdx += wordLength;
            }
            if (map.equals(dict)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private Map<String, Integer> initDict(String[] words) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!dict.containsKey(words[i])) {
                dict.put(words[i], 1);
            }
            else{
                Integer cnt = dict.get(words[i]);
                dict.put(words[i], cnt + 1);
            }
        }
        return dict;
    }
}