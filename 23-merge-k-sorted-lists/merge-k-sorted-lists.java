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
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // for(int i=0;i<lists.length;i++){
        //     ListNode temp=lists[i];
        //     while(temp!=null){
        //         pq.add(temp.val);
        //         temp=temp.next;
        //     }
        // }
        // ListNode dummy=new ListNode(0);
        // ListNode head=dummy;
        // while(!pq.isEmpty()){
        //     head.next = new ListNode(pq.poll());
        //     head=head.next;
        // }
        // return dummy.next;
        return merge(lists);
    }
    public ListNode merge(ListNode[] list){
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode Dummy=new ListNode();
        ListNode temp=Dummy;
        for(int i=0;i<list.length;i++){
            if(list[i]!=null){
                pq.add(list[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode r=pq.poll();
            Dummy.next=r;
            Dummy=Dummy.next;
            if(r.next!=null){
                pq.add(r.next);
            }
        }
        return temp.next;
    }
}