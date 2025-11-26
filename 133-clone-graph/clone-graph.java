/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        HashMap<Node,Node> mp=new HashMap<>();
        return BFS(node,mp);
    }
    public Node BFS(Node node,HashMap<Node,Node> mp){
        Node nn=new Node(node.val);
        mp.put(node,nn);
        Queue<Node> pq=new LinkedList<>();
        pq.add(node);//original node
        while(!pq.isEmpty()){
            // remove
            Node rv=pq.poll();

            // addd univisted neigbours
            for(Node nbrs:rv.neighbors){
                if(!mp.containsKey(nbrs)){
                    mp.put(nbrs,new Node(nbrs.val));
                    pq.add(nbrs);//add original neighbours
                }
                // mp.get(nn)-> clone of that node and mp.get(nbrs)->clone of that neighbor
                mp.get(rv).neighbors.add(mp.get(nbrs));

            }
        }
        return nn;
    }
}