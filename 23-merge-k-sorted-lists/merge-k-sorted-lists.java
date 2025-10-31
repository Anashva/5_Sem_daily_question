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

        
        return sort(lists);
    }
    public ListNode merge(ListNode[] list){
        // PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator <>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }
        });
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
















    public ListNode sort(ListNode[] list){
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
        for(int i=0;i<list.length;i++){
        if(list[i]!=null){
            pq.add(list[i]);
        }
       }
       ListNode dummy=new ListNode();
       ListNode temp=dummy;
       while(!pq.isEmpty()){
        ListNode r=pq.poll();
        dummy.next=r;
        dummy=dummy.next;
        if(r.next!=null){
            pq.add(r.next);
        }
       }
       dummy.next=null;
       return temp.next;
    }
}