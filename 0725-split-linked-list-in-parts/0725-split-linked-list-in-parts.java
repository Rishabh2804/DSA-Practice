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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        
        int len = 0;
        for(ListNode temp = head; temp != null; temp = temp.next)
            len ++;
        
        int partLen = len / k;
        int extra = len % k;
        
        for(int split = 0; split < k; ++split){
            if(head == null) break;
            parts[split] = head;
            
            ListNode prev = null;
            
            int lim = partLen;
            if(extra != 0){
                lim ++;
                extra --;
            }
            
            for(int i = 0; i < lim; ++i){
                prev = head;
                head = head.next;
            }
            
            if(prev == null) break;
            
            prev.next = null;
        }
        
        return parts;
    }
}