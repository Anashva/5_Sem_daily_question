class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n=edges.size();
        int[] ans=new int[n];
        List<Integer>[] ll=new ArrayList[n];
        for(int i=0;i<n;i++){
            ll[i]=new ArrayList<>();
        }
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            ll[i].add(edges.get(i));
            in[edges.get(i)]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        // removing non cycle edges
        while(!q.isEmpty()){
            int r=q.poll();
            for(int nbr:ll[r]){
                in[nbr]--;
                if(in[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(in[i]>0 && !visit[i]){
                int curr=i;
                int c=0;
                // finding cycle size
                while(!visit[curr]){
                    c++;
                    visit[curr]=true;
                    curr=edges.get(curr);
                }
                curr=i;
                // assiging value to cycle element 
                while(ans[curr]==0){
                    ans[curr]=c;
                    curr=edges.get(curr);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(in[i]==0){
                ans[i]=dfs(i,edges,ans);
            }
        }
        return ans;
    }
    public int dfs(int u,List<Integer> ll,int[] ans){
        if(ans[u]!=0){
            return ans[u];
        }
        ans[u]=1+dfs(ll.get(u),ll,ans);
        return ans[u];
    }
}