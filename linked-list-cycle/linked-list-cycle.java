/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tempHead1 = head;
        ListNode tempHead2 = head;
        while (tempHead2 != null && tempHead2.next != null){
            tempHead1 = tempHead1.next;
            tempHead2 = tempHead2.next.next;
            if (tempHead1 == tempHead2)
                return true;
        }
        return false;
    }
}