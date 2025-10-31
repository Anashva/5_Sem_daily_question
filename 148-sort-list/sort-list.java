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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=middle(head);
        ListNode midn=mid.next;
        mid.next=null;
        ListNode a=sortList(head);
        ListNode b=sortList(midn);
        return merge(a,b);
    }
    public  ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode A,ListNode B){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(A!=null && B!=null){
            if(A.val<B.val){
                dummy.next=A;
                A=A.next;
            }
            else{
                dummy.next=B;
                B=B.next;
            }
            dummy=dummy.next;
        }
        if(A==null){
            dummy.next=B;
        }
        if(B==null){
            dummy.next=A;
        }
        return temp.next;
    }
}