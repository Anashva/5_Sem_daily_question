class Solution {
    List<Integer>[] ll;
    int[] ans;
    int[] dp;
    int[] size;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans=new int[n];
        dp=new int[n];
        size=new int[n];
        ll=new ArrayList[n];
        for(int i=0;i<n;i++){
            ll[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            ll[e[0]].add(e[1]);
            ll[e[1]].add(e[0]);
        }
        dfs1(0,0);//findig size and distance(dp)
        ans[0]=dp[0];
        dfs2(n,0,0);//rerooting
        return ans;
    }
    public void dfs1(int u,int parent){
        size[u]=1;
        dp[u]=0;
        for(int v:ll[u]){
            if(v==parent){
                continue;
            }
            dfs1(v,u);
            size[u]+=size[v];
            dp[u]+=dp[v]+size[v];
        }
    }
    public void dfs2(int n,int u,int parent){
        
        for(int v:ll[u]){
            if(v==parent){
                continue;
            }
            ans[v]=ans[u]-size[v]+(n-size[v]);
            dfs2(n,v,u);
        }
    }
}