class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public int minScore(int n, int[][] roads) {
         mp =new HashMap<>();
        for(int i=1;i<=n;i++){
            mp.put(i,new HashMap<>());
        }
        for(int[] e:roads){
            int v1=e[0];
            int v2=e[1];
            int dis=e[2];
            mp.get(v1).put(v2,dis);
            mp.get(v2).put(v1,dis);
        }
        return dijkstra();

    }
    public int dijkstra(){
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new pair(1,Integer.MAX_VALUE));
        HashSet<Integer> st=new HashSet<>();
        int ans=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            pair r=pq.poll();
            if(st.contains(r.vtx)){
                continue;
            }
            ans=Math.min(ans,r.dis);
            st.add(r.vtx);
            for(int nbrs:mp.get(r.vtx).keySet()){
                if(!st.contains(nbrs)){
                    int dis=Math.min(mp.get(r.vtx).get(nbrs),r.dis);
                    pq.add(new pair(nbrs,dis));
                }
            }

        }
        return ans;
    }
    class pair{
        int vtx;
        int dis;
        public pair(int vtx,int dis){
            this.vtx=vtx;
            this.dis=dis;
        }
    }

}