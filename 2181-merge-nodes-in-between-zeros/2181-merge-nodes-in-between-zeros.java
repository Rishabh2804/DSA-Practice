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
    private ListNode solve(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode next = solve(head.next);
        if(head.val == 0){
            head.next = next;
            return head;
        }
        else {
            next.val += head.val;
            return next;
        }
    }
    
    public ListNode mergeNodes(ListNode head) {
        return solve(head.next);
    }
}