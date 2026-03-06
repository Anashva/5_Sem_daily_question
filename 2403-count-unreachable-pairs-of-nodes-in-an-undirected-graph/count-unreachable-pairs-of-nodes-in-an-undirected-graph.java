class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] ll=new ArrayList[n];
        for(int i=0;i<n;i++){
            ll[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            ll[e[0]].add(e[1]);
            ll[e[1]].add(e[0]);
        }
        long ans=0;
        int node=n;
        HashSet<Integer> st=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!st.contains(i)){
                // st.add(i);
                q.add(i);
                int c=0;
                while(!q.isEmpty()){
                    int r=q.poll();
                    if(st.contains(r)){
                        continue;
                    }
                    st.add(r);
                    c++;
                    for(int nbr:ll[r]){
                        if(!st.contains(nbr)){
                            q.add(nbr);
                        }
                    }
                }
                node-=c;
                ans+=(long)node*c;
            }
        }
        return ans;
    }
}