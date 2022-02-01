/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tempHead = head;
        while (tempHead != null){
            stack.push(tempHead.val);
            tempHead = tempHead.next;
        }
        int tempVal = 0;
        while(head!= null){
            tempVal  = stack.pop();
            if (tempVal != head.val)
                return false;
            head = head.next;
        }
        return true;
    }
}