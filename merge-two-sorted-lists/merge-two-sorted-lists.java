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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode();
        
        ListNode returnNode = tempNode;
        
        while(true){
            if (list1 == null || list2 == null)
                break;
            if (list1.val < list2.val){
                tempNode.next = list1;
                list1 = list1.next;
            }else{
                tempNode.next = list2;
                list2 = list2.next;
            }
            tempNode = tempNode.next;
            
        }
        if (list1 == null){
            tempNode.next = list2;
        }
        if (list2 == null){
            tempNode.next = list1;
        }
        return returnNode.next;
    }
    
}