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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        int toRemove = b - a + 1;
        
        ListNode tail1 = list1;
        while(tail1 != null){
            if(a == 1) break;
            
            a --;
            tail1 = tail1.next;            
        }

        ListNode end = tail1.next;
        while(end != null) {
            if(toRemove == 0) break;
            
            toRemove --;
            end = end.next;
        }
        
        ListNode tail2 = list2;        
        while(tail2 != null && tail2.next != null) 
            tail2 = tail2.next;
        
        // if(tail2 == null) {
        //     tail1.next = end;
        //     return list1;
        // }
        
        tail1.next = list2;
        tail2.next = end;
        
        return list1;
    }
}