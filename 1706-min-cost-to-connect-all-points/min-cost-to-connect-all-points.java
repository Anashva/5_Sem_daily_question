class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public int minCostConnectPoints(int[][] points) {
        mp=new HashMap<>();
        for(int i=0;i<points.length;i++){
            mp.put(i,new HashMap<>());
        }
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[j][1]-points[i][1]);
                mp.get(i).put(j,cost);
                mp.get(j).put(i,cost);
            }
        }
        return Kruskal_Algo();
    }
    public List<EdgePair> getAllEdge(){
        List<EdgePair> ll=new ArrayList<>();
        for(int e1:mp.keySet()){
            for(int e2:mp.get(e1).keySet()){
                int cost=mp.get(e1).get(e2);
                ll.add(new EdgePair(e1,e2,cost));
            }
        }
        return ll;
    }
    public int Kruskal_Algo(){
        List<EdgePair> ll=getAllEdge();
        Collections.sort(ll,(a,b)->a.cost-b.cost);
        DSU dsu=new DSU();
        for(int v:mp.keySet()){
            dsu.create(v);
        }
        int ans=0;
        for(EdgePair e: ll){
            int re1=dsu.find(e.e1);
            int re2=dsu.find(e.e2);
            if(re1!=re2){
                dsu.union(re1,re2);
                ans+=e.cost;
            }
        }
        return ans;
    }
    class EdgePair{
        int e1;
        int e2;
        int cost;
        public EdgePair(int e1,int e2,int cost){
            this.e1=e1;
            this.e2=e2;
            this.cost=cost;
        }
    }
    class DSU{
        class Node{
            int val;
            int rank;
            Node parent;
            Node(){

            }
        }
        HashMap<Integer,Node> map=new HashMap<>();
        public void create(int v){
            Node nn=new Node();
            nn.val=v;
            nn.rank=0;
            nn.parent=nn;
            map.put(v,nn);
        }
        public int find(int v){
            Node node=map.get(v);
            return find(node).val;
        }
        private Node find(Node node){
            if(node.parent==node){
                return node;
            }
            Node n=find(node.parent);
            node.parent=n;
            return n;
        }
        public void union(int v1,int v2){
            Node node1=map.get(v1);
            Node node2=map.get(v2);
            Node re1=find(node1);
            Node re2=find(node2);
            if(re1.rank==re2.rank){
                re1.parent=re2;
                re2.rank++;
            }
            else if(re1.rank<re2.rank){
                re1.parent=re2;
            }
            else{
                re2.parent=re1;
            }
        }
    }
}