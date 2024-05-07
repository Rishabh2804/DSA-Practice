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
    
    private int carryDouble(ListNode head){
        if(head == null) return 0;
        
        int carry = carryDouble(head.next);
        
        int currVal = head.val;
        currVal = 2 * currVal + carry;
        
        carry = currVal / 10;
        currVal = currVal % 10;
        
        head.val = currVal;
        return carry;
    }
    
    public ListNode doubleIt(ListNode head) {
        
        int carry = carryDouble(head);
        if(carry != 0){
            ListNode head1 = new ListNode(carry);
            head1.next = head;
            return head1;
        }
        
        return head;
    }
}