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
    static int carry = 0;
    
    private ListNode add(ListNode l1, ListNode l2){        
        if(l1 == null) {
            if(carry == 0 || l2 == null) return l2;
            int sum = l2.val + carry;
            l2.val = sum % 10;
            carry = sum / 10;
            
            l2.next = add(l2.next, l1);
            return l2;
        }
        
        if(l2 == null) {
            if(carry == 0 || l1 == null) return l1;
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            
            l1.next = add(l1.next, l2);
            return l1;
        }
        
        int val1 = 0;
        int val2 = 0;
        
        int sum = l1.val + l2.val + carry;
        l1.val = sum % 10;
        carry = sum / 10;
        
        l1.next = add(l1.next, l2.next);
        return l1;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        carry = 0;
        ListNode temp = null;
        
        ListNode rev1 = null;
        while(l1 != null){
            temp = l1.next;
            l1.next = rev1;
            rev1 = l1;
            
            l1 = temp;
        }
        
        ListNode rev2 = null;
        while(l2 != null){
            temp = l2.next;
            l2.next = rev2;
            rev2 = l2;
            
            l2 = temp;
        }
        
        rev1 = add(rev1, rev2);
        while(rev1 != null){
            temp = rev1.next;
            rev1.next = l1;
            l1 = rev1;
            
            rev1 = temp;
        }
        
        if (carry != 0)
            l1 = new ListNode(carry, l1);
        
        return l1;
    }
}