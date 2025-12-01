class Solution {
    HashMap<Integer,List<Integer>> mp;
    public int countCompleteComponents(int n, int[][] edges) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] e:edges){
            int v1=e[0];
            int v2=e[1];
            mp.get(v1).add(v2);
            mp.get(v2).add(v1);
        }
        return bft(n);
    }
    public int bft(int n){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> st=new HashSet<>();
        int ans=0;
        for(int src:mp.keySet()){
            if(st.contains(src)){
                continue;
            }
            List<Integer> ll=new ArrayList<>();
            q.add(src);
            int edge=0;
            while(!q.isEmpty()){
                // remove
                int r=q.poll();

                // ignore
                if(st.contains(r)){
                    continue;
                }

                // mark visited
                st.add(r);
                ll.add(r); //no of nodes in complete component

                // self work

                // add nbrs
                for(int nbrs:mp.get(r)){
                    edge++;//no of edges in complete component
                    if(!st.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }

            // complete component condition
            int vtx=ll.size();
            if((edge/2) == vtx*(vtx-1)/2){
                ans++;
            }
        }
        return ans;
    }
}