class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n=scores.length;
        List<int[]>[] ll=new ArrayList[n];
        for(int i=0;i<n;i++){
            ll[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            ll[u].add(new int[]{v,scores[v]});
            ll[v].add(new int[]{u,scores[u]});
        }
        for(int i=0;i<n;i++){
            Collections.sort(ll[i],(a,b)->b[1]-a[1]);
            
        }
        for(int i=0;i<n;i++){
            if(ll[i].size()>3){
                ll[i]=new ArrayList<>(ll[i].subList(0,3));
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            for(int[] x:ll[u]){
                if(x[0]==v){
                    continue;
                }
                for(int[] y:ll[v]){
                    if(y[0]==u || x[0]==y[0]){
                        continue;
                    }
                    int total=x[1]+y[1]+scores[u]+scores[v];
                    ans=Math.max(ans,total);
                }
            }
        }
        return ans==Integer.MIN_VALUE ? -1 : ans;
    }
}