class Solution {
    HashMap<String,HashMap<String,Double>> mp;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        mp=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            mp.putIfAbsent(a,new HashMap<>());
            mp.putIfAbsent(b,new HashMap<>());
            mp.get(a).put(b,values[i]);
            mp.get(b).put(a,1.0/values[i]);
        }
        return bfs(queries);
    }
    public double[] bfs(List<List<String>> queries){
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            if(!mp.containsKey(a) || !mp.containsKey(b)){
                ans[i]=-1.0;
                continue;
            }
            if (a.equals(b)) {
                ans[i] = 1.0;
                continue;
            }
                HashSet<String> st=new HashSet<>();
                Queue<pair> pq=new LinkedList<>();
                pq.add(new pair(a,1.0));
                double val=-1.0;
                while(!pq.isEmpty()){
                    pair r=pq.poll();
                    if(r.s.equals(b)){
                        val=r.k;
                    }
                    if(st.contains(r.s)){
                        continue;
                    }
                    st.add(r.s);
                    for(String nbrs:mp.get(r.s).keySet()){
                        if(!st.contains(nbrs)){
                            double wt=mp.get(r.s).get(nbrs);
                            pq.add(new pair(nbrs,r.k*wt));
                        }
                    }
                }
                ans[i]=val;
        }
        return ans;
    }
    class pair{
        String s;
        Double k;
        public pair(String s,Double k){
            this.s=s;
            this.k=k;
        }
    }
}