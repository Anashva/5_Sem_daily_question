class Solution {
    HashMap<Integer,HashMap<Integer,Double>> mp;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new HashMap<>());
        }
        for(int i=0;i<edges.length;i++){
            mp.get(edges[i][0]).put(edges[i][1],succProb[i]);
            mp.get(edges[i][1]).put(edges[i][0],succProb[i]);
        }
        return path(start_node,end_node);

    }
    public double path(int src,int des){
        PriorityQueue<pair> pq=new PriorityQueue<>( (a,b)-> Double.compare(b.cost, a.cost));
        pq.add(new pair(src,1.0));
        HashSet<Integer> st=new HashSet<>();
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            if(rp.vtx==des){
                return rp.cost;
            }
            if(st.contains(rp.vtx)){
                continue;
            }
            st.add(rp.vtx);
            for(int nbrs:mp.get(rp.vtx).keySet()){
                double cost=mp.get(rp.vtx).get(nbrs);
                if(!st.contains(nbrs)){
                    pq.add(new pair(nbrs,rp.cost*cost));
                }
            }
        }
        return 0.00000;
    }
    class pair{
        int vtx;
        double cost;
        public pair(int vtx,double cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}