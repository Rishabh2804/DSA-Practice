/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                break;
        }
        
        if(fast == null || fast.next == null)
            return null;
        
        ListNode temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }        
        
        return temp;
    }
}

// 1 2     3  4  5  6  7  8  9  10
//     start              end 
//         <----------m---------->
//         s     f  
// <---x--><--x--><-------y------>   => m = x + y
// <------2x----->

// <--x--><-------y------><--x-->
//                       sf         => meet idx = m
// <----------m---------->
//         <----------m---------->  => x + y = y + x
//                                  
//    (meet idx + x) % m 
// => (m + x) % m
// => (m % m) + (x % m)
// => x

// Thus, after x moves :
// - slow will return to idx x
// - a new pointer starting from head will reach x

// i.e. x = meet point of temp & slow




