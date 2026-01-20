class Solution {
    int[][] dp;
    HashMap<Integer,List<Integer>> mp;
    public int largestPathValue(String s, int[][] edges) {
        int n =s.length();
        dp=new int[n][26];
        int[] indegree=new int[n];
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            mp.get(u).add(v);
            indegree[v]++;
        }
        for(int i=0;i<n;i++){
            int ch=s.charAt(i)-'a';
            dp[i][ch]=1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ans=0;
        int c=0;
        while(!q.isEmpty()){
            int r=q.poll();
            c++;
            // for(int i=0;i<26;i++){
            //     ans=Math.max(ans,dp[r][i]);
            // }
            for(int nbr:mp.get(r)){
                for(int i=0;i<26;i++){
                    int ch=s.charAt(nbr)-'a';
                    int d=0;
                    if(ch==i){
                        d=1;
                    }
                    dp[nbr][i]=Math.max(dp[r][i]+d,dp[nbr][i]);
                }
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
            for(int i=0;i<26;i++){
                ans=Math.max(ans,dp[r][i]);
            }
        }
        return c<n ? -1 : ans;
    }
}