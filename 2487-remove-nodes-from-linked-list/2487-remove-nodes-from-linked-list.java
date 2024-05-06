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
    
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode rest = removeNodes(head.next);
        if(rest == null || rest.val <= head.val)
            head.next = rest;
        else head = rest;
        
        return head; 
    }
}