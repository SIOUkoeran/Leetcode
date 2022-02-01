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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode1 = head;
        ListNode tempNode2 = head;
        
        int idx = 0;
        while (true){
            if (tempNode1 == null)
                break;
            tempNode1 = tempNode1.next;
            idx++;
        }
        if (idx == 1){
            return null;
        }
        if (n == idx){
            return head.next;
        }
        for (int i = 0; i < idx - n - 1; i++){
            tempNode2 = tempNode2.next;
        }
        tempNode2.next = tempNode2.next.next;
        return head;
    }
}