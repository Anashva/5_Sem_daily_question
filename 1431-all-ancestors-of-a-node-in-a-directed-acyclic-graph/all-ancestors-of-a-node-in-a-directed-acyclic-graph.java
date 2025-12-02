class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        int[] in=new int[n];
        // using reverse graph -adding parent so that we can acccess its ancestor later
        for(int [] e:edges){
            int v1=e[0];
            int v2=e[1];
            mp.get(v1).add(v2);
            in[v2]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        List<Set<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new HashSet<>());
        }
        while(!q.isEmpty()){
            int r=q.poll();
            for(int nbrs:mp.get(r)){
                ans.get(nbrs).add(r);
                ans.get(nbrs).addAll(ans.get(r));
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> ll = new ArrayList<>(ans.get(i));
            Collections.sort(ll);
            res.add(ll);
        }
        
        return res;
    }
}