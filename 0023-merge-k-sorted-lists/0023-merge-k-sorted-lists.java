class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> nodes = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null)
                nodes.add(head);
        }
        
        ListNode head = nodes.poll();
        if (head == null)
            return head;
            
        if(head.next != null)
            nodes.add(head.next);

        ListNode tail = head;
        while (!nodes.isEmpty()) {
            ListNode curr = nodes.poll();
            tail.next = curr;
            tail = tail.next;

            if(curr.next != null)
                nodes.add(curr.next);
        }

        return head;
    }
}