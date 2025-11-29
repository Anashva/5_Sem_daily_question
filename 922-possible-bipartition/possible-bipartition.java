class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        
        }
        for(int[] e:dislikes){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        HashMap<Integer,Integer>  mp=new HashMap<>();
        Queue<BipartitePair> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(mp.containsKey(i)){
                continue;
            }
            q.add(new BipartitePair(i,0));
            while(!q.isEmpty()){
                BipartitePair rp=q.poll();
                if(mp.containsKey(rp.vtx)){
                    if(mp.get(rp.vtx)!=rp.dis){
                        return false;
                    }
                    continue;
                }
                mp.put(rp.vtx,rp.dis);
                for(int nbrs:graph[rp.vtx]){
                    if(!mp.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs,rp.dis+1));
                    }
                }
            }
        }
        return true;
    }
    class BipartitePair{
        int vtx;
        int dis;
        public BipartitePair(int vtx,int dis){
            this.vtx=vtx;
            this.dis=dis;
        }
    }
}