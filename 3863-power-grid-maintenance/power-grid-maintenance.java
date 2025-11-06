class Solution {
    private HashMap<Integer,List<Integer>> mp;
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        mp = new HashMap<>();
        for(int i=1;i<=c;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int v1=connections[i][0];
            int v2=connections[i][1];
            AddEdge(v1,v2);
        }
        // mapping vtx to component id
        HashMap<Integer,Integer> map=new HashMap<>();
        int id=1;
        HashMap<Integer,TreeSet<Integer>> st=new HashMap<>();
        HashSet<Integer> visit=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        // bfs
        for(int key:mp.keySet()){
            if(visit.contains(key)){
                continue;
            }
            st.put(id,new TreeSet<>());
            q.add(key);
            while(!q.isEmpty()){
                // remove
                int rv=q.poll();

                // ignore
                if(visit.contains(rv)){
                    continue;
                }
                // mark visited
                visit.add(rv);

                // self work
                map.put(rv,id);
                st.get(id).add(rv);
                
                // add unvisited nbrs
                for(int nbrs:mp.get(rv)){
                    if(!visit.contains(nbrs)){
                        q.add(nbrs);
                    }
                }

            }
            id++;
        }
        int idx=0;
        for(int[] qr:queries){
            if(qr[0]==1){
                idx++;
            }
        }
        int[] ans=new int[idx];
        idx=0;
        for(int [] qr:queries){
            int cid=map.get(qr[1]);
            if(qr[0]==1){
                if(st.get(cid).contains(qr[1])){
                    ans[idx++]=qr[1];
                }
                else if(st.get(cid).size()>0){
                    ans[idx++]=st.get(cid).first();
                }
                else{
                    ans[idx++]=-1;
                }
            }
            else{
                if(st.get(cid).contains(qr[1])){
                    st.get(cid).remove(qr[1]);
                }
            }
        }
        return ans;
    }
    public void AddEdge(int v1,int v2){
        mp.get(v1).add(v2);
        mp.get(v2).add(v1);
    }
    
}