class Solution {
    List<int[]>[] mp;
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n=passingFees.length;
        mp=new ArrayList[n];
        for(int i=0;i<n;i++){
            mp[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            int time=edges[i][2];
            mp[v1].add(new int[]{v2,time});
            mp[v2].add(new int[]{v1,time});
        }
        return dijkstra(n,passingFees,maxTime);
    }
    public int dijkstra(int n,int[] passingFees,int maxTime){
        int[] time=new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>(((a,b)->a[2]-b[2]));
        pq.add(new int[]{0,0,passingFees[0]});
        time[0]=0;
        cost[0]=passingFees[0];
        while(!pq.isEmpty()){
            int[] rp=pq.poll();
            int timee=rp[1];
            int costs=rp[2];
            int r=rp[0];

            if(timee>time[r] && costs>cost[r] ){
                continue;
            }

            for(int[] nbrs:mp[r]){
                int nb=nbrs[0];
                int t=nbrs[1]+timee;
                int nc=costs+passingFees[nb];
                if(t<=maxTime){
                    if(t<time[nb] || nc<cost[nb]){
                        if (t < time[nb]) time[nb] = t;
                        if (nc < cost[nb]) cost[nb] = nc;
                        pq.add(new int[]{nb,t,nc});
                    }
                }
            }
        }
        return cost[n-1]==Integer.MAX_VALUE ? -1 :cost[n-1];
    }
}