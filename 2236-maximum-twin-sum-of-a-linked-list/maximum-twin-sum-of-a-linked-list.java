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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode first=head;
        int ans=0;
        ListNode last=reverse(slow);
        while(first!=null && last!=null){
            ans=Math.max(ans,first.val+last.val);
            first=first.next;
            last=last.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode thead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=thead;
        }
        return prev;
    }
}