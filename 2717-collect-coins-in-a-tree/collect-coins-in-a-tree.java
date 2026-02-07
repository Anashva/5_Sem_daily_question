class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n=coins.length;
        if(edges.length==0){
            return 0;
        }
        int ans=n;
        List<Integer>[] mp=new ArrayList[n];
        for(int i=0;i<n;i++){
            mp[i]=new ArrayList<>();
        }
        int[] ind=new int[n];
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            mp[u].add(v);
            mp[v].add(u);
            ind[u]++;
            ind[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==1 && coins[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int r=q.poll();
            ans--;
            for(int nbr:mp[r]){
                ind[nbr]--;
                if(ind[nbr]==1 && coins[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ind[i]==1 && coins[i]==1){
                q.add(i);
            }
        }
        ans-=q.size();
        for(int ele:q){
            ind[ele]--;
            for(int nbr:mp[ele]){
                ind[nbr]--;
                if(ind[nbr]==1){
                    ans--;
                }
            }
        }
        return Math.max(0,(ans-1)*2);
    }
}