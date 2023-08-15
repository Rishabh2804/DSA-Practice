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
    
    public ListNode partition(ListNode head, int x) {
        
        ListNode head1 = null;
        ListNode tail1 = null;
        ListNode head2 = null;
        ListNode tail2 = null;
        
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                if(head1 == null){
                    head1 = temp;
                    tail1 = temp;
                } else {
                    tail1.next = temp;
                    tail1 = tail1.next;
                }
            } else{
                if(head2 == null){
                    head2 = temp;
                    tail2 = temp;
                } else {
                    tail2.next = temp;
                    tail2 = tail2.next;
                }
            }
            
            temp = temp.next;
        }
                
        if(head1 == null) return head2;
        else if(head2 == null) return head1;
        
        tail1.next = head2;
        tail2.next = null;
        
        return head1;        
    }
}