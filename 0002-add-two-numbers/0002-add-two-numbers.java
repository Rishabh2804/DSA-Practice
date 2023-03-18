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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        
        if(l1 == null){
            int carry = l2.val / 10;
            if(carry != 0){
                l2.val %= 10;
                l2.next = addTwoNumbers(new ListNode(carry), l2.next);
            }
            
            return l2;
        }
        
        if(l2 == null)
            return l1;
        
        int sum = l1.val + l2.val;
        l1.val = sum % 10;
        
        int carry = sum / 10;        
        if(carry != 0){
            if(l2.next == null)
                l2.next = new ListNode(carry);
            else
                l2.next.val += carry;
        }
        
        l1.next = addTwoNumbers(l1.next, l2.next);
        return l1;
    }
}