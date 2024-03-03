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
        
        ListNode start = head, end = head;
        while(end != null){            
            if(n == 0)
                break;
            
            n--;
            end = end.next;
        }
        
        if(end == null)
            return head.next;
        
        while(end.next != null){
            start = start.next;
            end = end.next;
        }
        
        start.next = start.next.next;
        return head;
    }
}