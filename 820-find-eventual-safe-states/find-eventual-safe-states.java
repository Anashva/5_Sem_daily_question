class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] outd=new int[n];
        List<Integer>[] mp=new ArrayList[n];
        for(int i=0;i<n;i++){
            mp[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            int[] arr=graph[i];
            for(int j=0;j<arr.length;j++){
                outd[i]++;
                mp[arr[j]].add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<outd.length;i++){
            if(outd[i]==0){
                q.add(i);
            }
        }
        List<Integer> ll=new ArrayList<>();
        while(!q.isEmpty()){
            int r=q.poll();
            ll.add(r);
            for(int nbr:mp[r]){
                outd[nbr]--;
                if(outd[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        Collections.sort(ll);
        return ll;
    }
}