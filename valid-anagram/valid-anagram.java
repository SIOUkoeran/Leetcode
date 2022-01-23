class Solution {
    public boolean isAnagram(String s, String t) {
        LinkedList<Character> linkedList = new LinkedList<>();
        int idx;
        for (int i = 0; i < t.length(); i++){
            linkedList.add(t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++){
            idx = linkedList.indexOf(s.charAt(i));
            if (idx > -1){
                linkedList.remove(idx);
            }else{
                return false;
            }
        }
        if (linkedList.size() > 0)
            return false;
        return true;
    }
}