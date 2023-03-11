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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next == null)
            return new TreeNode(head.val);
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(true){
            fast = fast.next.next;
            if(fast == null || fast.next == null)
                break;
            
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.next.val);
        root.right = sortedListToBST(slow.next.next);
        
        slow.next = null;
        root.left = sortedListToBST(head);
        
        return root;
    }
}


// Odd :-  1 --> 2 --> 3 --> null
// init -> sf
//    1    s           f        f != null
//               s     f

//    2    (will not enter, as f.next == null)
//    =>   mid = s = 2

// Even :- 1 --> 2 --> 3 --> 4 --> null
// init -> sf
//    1    s           f                f != null
//               s

//    2          s                 f    f == null
//    =>  mid = s = 2