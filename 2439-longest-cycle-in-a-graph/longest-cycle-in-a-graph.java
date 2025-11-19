class Solution {
    public int longestCycle(int[] edges) {
        return longestcycle(edges);
    }
    public static int longestcycle(int[] edges){
        int[] in=new int [edges.length];
        for (int i=0;i<edges.length;i++){
            if(edges[i]<0){
                continue;
            }
            in[edges[i]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<in.length;i++){
            if (in[i]==0){
                q.add(i);
            }
        }
        HashSet<Integer> st=new HashSet<>();
        while(!q.isEmpty()){
            int e=q.poll();
            st.add(e);
            if(edges[e]!=-1){
                in[edges[e]]--;
                if (in[edges[e]]==0){
                q.add(edges[e]);
            }
            }
            
        }
        int ans=-1;
        for (int i=0;i<edges.length;i++){
            if(!st.contains(i)){
                int c=1;
                int nbrs=edges[i];
                while(nbrs!=i){
                    c++;
                    st.add(nbrs);
                    nbrs=edges[nbrs];
                }
                ans= Math.max(ans,c);
            }
        }
        return ans;
    }
}