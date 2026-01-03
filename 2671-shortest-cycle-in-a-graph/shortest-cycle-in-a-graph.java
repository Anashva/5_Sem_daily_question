class Solution {
    HashMap<Integer,List<Integer>> mp;
    public int findShortestCycle(int n, int[][] edges) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] e:edges){
            mp.get(e[0]).add(e[1]);
            mp.get(e[1]).add(e[0]); 
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int[] dis=new int[n];
            int[] parent=new int[n];
            Arrays.fill(dis,-1);
            Arrays.fill(parent,-1);
            dis[i]=0;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int r=q.poll();
                for(int nbr:mp.get(r)){
                    if(dis[nbr]==-1){//agr pehli bar koi node visit ho rha h  
                        parent[nbr]=r;
                        dis[nbr]=dis[r]+1;
                        q.add(nbr);
                    }
                    else if(parent[r]!=nbr){ // node agr already visit ho chuka h but uska parent nhi h
                        ans=Math.min(ans,dis[nbr]+dis[r]+1);
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
}