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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int c=0;
        // ListNode temp=head;
        // while(temp!=null){
        //     c++;
        //     temp=temp.next;
        // }
        // if(c==n){
        //     return head.next;
        // }
        // temp=head;
        // for(int i=1;i<c-n;i++){
        //     temp=temp.next;
        // }
        // temp.next=temp.next.next;
        // return

        Stack<ListNode> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp);
            temp=temp.next;
        }
        for(int i=0;i<n;i++){
            temp=st.pop();//finding target node
        }
        if(st.isEmpty()){
            return head.next;
        }
        ListNode prev=st.peek();
        prev.next=temp.next;
        return head;
    }
}