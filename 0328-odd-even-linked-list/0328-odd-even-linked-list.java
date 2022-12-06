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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        
        ListNode oddTail = odd;
        ListNode evenTail = even;
        
        while(oddTail.next != null && evenTail.next != null){                        
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        
        oddTail.next = even;
        
        return odd;
    }
}