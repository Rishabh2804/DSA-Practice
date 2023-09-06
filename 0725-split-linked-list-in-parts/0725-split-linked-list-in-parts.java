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
    // Total no of parts = k;
    // Let the first y parts be of length x + 1
    // Remaining parts (k - y) would be of length x
    
    // y*(x + 1) + (k - y)*x = n
    // xy + y + kx - xy = n
    // kx + y = n
    
    private int getSize(ListNode head){
        int n = 0;
        while(head != null){
            n++;
            head = head.next;
        }
        
        return n;
        // or simply return 1 + getSize(head.next);
    }
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        if(head == null) return parts;
        
        int n = getSize(head);
        
        int x = n / k;
        int y = n % k;
        
        int i = 0;
        int j = 0;
        // ListNode tail = head;
        while(head != null && j < y){
            if(parts[j] == null) parts[j] = head;
            
            if(i == x){
                i = 0;
                j++;
                ListNode temp = head;
                head = head.next;
                temp.next = null;
            } else {
                i++;
                head = head.next;
            }
        }
        
        while(head != null && j < k){
            if(parts[j] == null) parts[j] = head;
            
            if(i == x - 1){
                i = 0;
                j++;
                ListNode temp = head;
                head = head.next;
                temp.next = null;
            } else {
                i++;
                head = head.next;
            }
        }
        
        return parts;
    }
}