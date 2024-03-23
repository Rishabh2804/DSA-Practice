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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        Stack<ListNode> nodes = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            nodes.add(temp);
            temp = temp.next;
        }
        
        while(!nodes.isEmpty()){
            ListNode tail = nodes.pop();
            if(head == tail || head.next == tail) {
                tail.next = null;
                break;
            }
            
            tail.next = head.next;
            head.next = tail;
            head = tail.next;
        }
    }
}