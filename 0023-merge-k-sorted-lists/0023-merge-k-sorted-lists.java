class Solution {

    static class ListSorter<E> extends PriorityQueue<E> {

        private static final int DEFAULT_INITIAL_CAPACITY = 11;

        ListSorter(Comparator<E> c) {
            super(DEFAULT_INITIAL_CAPACITY, c);
        }

        @Override
        public boolean add(E e) {
            if (e == null)
                return false;

            return offer(e);
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListSorter<ListNode> nodes = new ListSorter<>((a, b) -> a.val - b.val);
        Collections.addAll(nodes, lists);

        ListNode head = nodes.poll();
        if(head != null)
            nodes.add(head.next);

        ListNode tail = head;
        while (!nodes.isEmpty()) {
            ListNode curr = nodes.poll();
            tail.next = curr;
            tail = tail.next;

            nodes.add(curr.next);
        }

        return head;
    }
}