class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;

    }
    
    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }
    
    public void addAtHead(int val) {
        AddFirst(val);
    }
    
    public void addAtTail(int val) {
        Addlast(val);
    }
    
    public void addAtIndex(int index, int val) {
        addatindex(val,index);
    }
    public void addatindex(int item,int k){
        if (k < 0 || k > size) {
            return;
        }
        if(k==0){
            AddFirst(item);
        }
        else if(k==size){
            Addlast(item);
        }
        else{
            Node nn=new Node(item);
            Node prev=getNode(k-1);
            nn.next=prev.next;
            prev.next=nn;
            size++;
        }

    }
    public void Addlast(int item){
        if(size==0){
            AddFirst(item);
            }
        else{
            Node nn=new Node(item);;
            tail.next=nn;
            tail=nn;
            size++;
        }
    }
    public void  AddFirst(int item){
        Node nn=new Node(item);
        if(size==0){
            head=nn;
            tail=nn;
            size++;
        }
        else{
            nn.next=head;
            head=nn;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        if(index==0 ){
            removeFirst();
        }
        else if(index==size-1){
            removelast();
        }
        else{
            Node prev=getNode(index-1);
            Node curr=getNode(index);
            prev.next=curr.next;
            curr.next=null;
            size--;

        }
    }
    public void removeFirst(){
        int val= head.val;
        if(size==1){
            head=null;
            tail=null;
            size=0;
        }
        else{
            Node temp=head;
            head=head.next;
            temp.next=null;
            size--;
        }
    }
    public void removelast(){
        if(size==1){
            removeFirst();
        }
        else{
            int val=tail.val;
            Node sl=getNode(size-2);
            sl.next=null;
            tail=sl;
            size--;
        }
    }
    private Node getNode(int k){
        if(k<0 || k>=size){
            return null;
        }
        Node temp=head;
        for(int i=0;i<k;i++){
            temp=temp.next;
        }
        return temp;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */