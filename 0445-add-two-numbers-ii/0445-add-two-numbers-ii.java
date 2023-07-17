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
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        
        ListNode rest=reverse(head.next);
        head.next.next=head;
        head.next=null;
        
        return rest;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        l1=reverse(l1);
        l2=reverse(l2);
        
        ListNode temp1=l1;
        ListNode temp2=l2;
        
        ListNode ans=null,temp3=null;
        int carry=0;
        
        while(temp1!=null || temp2!=null){
            int n1=0,n2=0;
            
            if(temp1!=null)
                n1=temp1.val;
            if(temp2!=null)
                n2=temp2.val;
            
            int sum= carry + n1 + n2;
            
            if(sum>9){
                carry=1;
                sum=sum%10;   
            }
            else
                carry=0;
            
            ListNode node=new ListNode(sum);
            if(ans==null){
                ans=node;
                temp3=ans;               
            }
            else{ 
                temp3.next=node;
                temp3=temp3.next;    
            }
            
            if(temp1!=null){
                temp1=temp1.next;
            }
            
            if(temp2!=null){
                temp2=temp2.next;
            }
            
            if(temp1==null && temp2==null && carry==1){
                ListNode one = new ListNode(1);
                temp3.next=one;
            }
        }
        
        return reverse(ans);
        
    
    }
}