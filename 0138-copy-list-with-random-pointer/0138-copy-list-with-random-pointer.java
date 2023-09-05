/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copies = new HashMap<>();
        
        Node temp = head;
        while(temp != null){
            copies.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        Node head1 = null;
        Node tail = null;
        
        temp = head;
        while(temp != null){
            Node copy = copies.get(temp);
            
            copy.next = copies.get(temp.next);
            copy.random = copies.get(temp.random);
            
            if(head1 == null){
                head1 = copy;
                tail = head1;
            } else{
                tail.next = copy;
                tail = tail.next;
            }
            
            temp = temp.next;
        }
        
        return head1;
    }
}