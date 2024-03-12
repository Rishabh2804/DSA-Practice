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
    private static final ListNode DUMMY = new ListNode(0);
    
    public ListNode removeZeroSumSublists(ListNode head) {
        DUMMY.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        
        int sum = 0;
        ListNode temp = DUMMY;        
        while(temp != null){
            sum += temp.val;
            map.put(sum, temp);            
            temp = temp.next;
        }
        
        sum = 0;
        temp = DUMMY;
        
        while(temp != null){
            sum += temp.val;
            temp.next = map.get(sum).next;
            temp = temp.next;
        }
        
        head = DUMMY.next;
        DUMMY.next = null;
        
        return head;
    }
}