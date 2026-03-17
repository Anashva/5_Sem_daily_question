class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] ll=new ArrayList[n+1];
        int[] dp=new int[n+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            ll[i]=new ArrayList<>();
        }
        int[] in=new int[n+1];
        for(int[] e:relations){
            ll[e[0]].add(e[1]);
            in[e[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(in[i]==0){
                q.add(i);
                dp[i]=time[i-1];
                ans=Math.max(ans,dp[i]);
            }
        }
        while(!q.isEmpty()){
            int r=q.poll();
            for(int nbr:ll[r]){
                dp[nbr]=Math.max(dp[nbr],dp[r]+time[nbr-1]);
                ans=Math.max(ans,dp[nbr]);
                in[nbr]--;
                if(in[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        return ans;
    }
}