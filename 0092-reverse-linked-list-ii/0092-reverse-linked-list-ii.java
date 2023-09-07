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
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return rest;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right)    
            return head;
        
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode tail1 = null;        
        
        ListNode temp = head;
    
        int i = 0;
        while(temp.next != null){
            i++;
            
            if(i == left - 1) {
                tail1 = temp;
                head1 = temp.next;
                temp.next = null;
                temp = head1;
                continue;
            }
            
            if(i == right) {
                head2 = temp.next;
                temp.next = null;
                temp = head2;
                continue;
            }
            
            temp = temp.next;
            
        }
        
        if(left == 1){
            head1 = head;
            tail1 = reverse(head1);
            head1.next = head2;
            return tail1;
        }
        
        ListNode tail2 = reverse(head1);
        tail1.next = tail2;
        head1.next = head2;
        
        return head;
    }
}