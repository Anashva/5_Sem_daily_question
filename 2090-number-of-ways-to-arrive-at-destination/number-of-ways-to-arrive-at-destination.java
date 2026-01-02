class Solution {
    long [] dis;
    int[] ans;
    int mod=(int)1000000007;
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public int countPaths(int n, int[][] roads) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new HashMap<>());
        }
        for(int [] e:roads){
            mp.get(e[0]).put(e[1],e[2]);
            mp.get(e[1]).put(e[0],e[2]);
        }
        dijkastra(n);
        return ans[n-1];
    }
    public void dijkastra(int n){
        dis=new long[n];
        ans=new int[n];
        ans[0]=1;
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            int vtx=rp.vtx;
            long time=rp.time;
            if(time>dis[vtx]){
                continue;
            }
            for(int nbrs:mp.get(vtx).keySet()){
                int t=mp.get(vtx).get(nbrs);
                if(t+time<dis[nbrs]){
                    dis[nbrs]=t+time;
                    ans[nbrs]=ans[vtx];
                    pq.add(new pair(nbrs,dis[nbrs]));
                }
                else if(t+time==dis[nbrs]){
                    ans[nbrs]=(ans[nbrs]+ans[vtx])%mod;
                }
            }
        }
    }
    class pair{
        int vtx;
        long time;
        public pair(int vtx,long time){
            this.vtx=vtx;
            this.time=time;
        }
    }
}