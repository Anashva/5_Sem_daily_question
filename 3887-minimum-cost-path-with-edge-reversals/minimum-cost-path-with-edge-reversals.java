class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public int minCost(int n, int[][] edges) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new HashMap<>());
        }
        for(int[]e:edges){
            int v1=e[0];
            int v2=e[1];
            int cost=e[2];
            mp.get(v1).put(v2,Math.min(mp.get(v1).getOrDefault(v2, Integer.MAX_VALUE), cost));
            mp.get(v2).put(v1,Math.min(mp.get(v2).getOrDefault(v1, Integer.MAX_VALUE), 2 * cost));
        }
        return dijkstra(n);
    }
    public int dijkstra(int n){
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new pair(0,0));
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            if(rp.cost>dis[rp.vtx]){
                continue;
            }
            if(rp.vtx==n-1){
                return rp.cost;
            }
            for(int nbrs:mp.get(rp.vtx).keySet()){
                int cost=mp.get(rp.vtx).get(nbrs);
                if(cost+rp.cost<dis[nbrs]){
                    dis[nbrs]=cost+rp.cost;
                    pq.add(new pair(nbrs,dis[nbrs]));
                }
            }
        }
        return dis[n-1]==Integer.MAX_VALUE ?-1 :dis[n-1];
    }
    class pair{
        int vtx;
        int cost;
        pair(int vtx,int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}