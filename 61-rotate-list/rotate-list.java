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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null || head.next == null){
            return head;
        }
        ListNode temp=head;
        int c=1;
        while(temp.next!=null){
            temp=temp.next;
            c++;
        }
        temp.next=head;
        k=k%c;
        int len=c-k;
        ListNode front=head;
        for(int i=1;i<len;i++){
            front=front.next;
        }
        ListNode tail=front.next;
        front.next=null;
        return tail;
    }
}