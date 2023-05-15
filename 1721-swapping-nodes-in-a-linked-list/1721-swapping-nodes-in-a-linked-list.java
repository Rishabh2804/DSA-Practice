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
    public ListNode swapNodes(ListNode head, int i,int j){
        int index=0;
        ListNode a,b,temp;                      //a : ith node  ;  b: jth node
        temp=head;
        a=b=null;

        while(temp!=null){
            if(index==Math.min(i, j))
               a=temp;
            if(index==Math.max(i, j))
               b=temp;
               
            index++;
            temp=temp.next;   
        }

        ListNode t1,t2,temp2;
        if(a==null)
           t1=head;
        else   
           t1=a.next;                        
        
        t2=b.next;

        if(Math.abs(i-j)==1){               //If consecitive nodes are to be swapped
           temp2=t1;

        }
        else
           temp2=t1.next;

        t1.next=t2.next;
        t2.next=temp2;

        if(Math.abs(i-j)!=1)
           b.next=t1;
        
        if(a==null)    
          head=t2;
        else
          a.next=t2;
        
        return head;
    }
    
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        ListNode temp=head;
        int len=0;
        
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        
        return swapNodes(head, k - 2, len - k - 1);
    }
}