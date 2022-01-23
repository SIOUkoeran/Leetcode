class Solution {
    public boolean isPalindrome(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        int length = s.length();
        for (int i = 0; i < length; i++){
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                linkedList.add(s.charAt(i));
            }
            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                linkedList.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        LinkedList<Character> reverseLinkedList = reverseString(linkedList);
        for (int i = 0; i < reverseLinkedList.size(); i++){
            if (reverseLinkedList.pollFirst() != linkedList.pollFirst()){
                return false;
            }
        }
        return true;
    }
    private static LinkedList reverseString(LinkedList<Character> linkedList){
        LinkedList<Character> returnLinkedList = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++){
            returnLinkedList.add(linkedList.get(linkedList.size() - i - 1));
        }
        return returnLinkedList;
    }
}