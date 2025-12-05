class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,ArrayList<int[]>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }

        for(int[] e:meetings){
            int v1=e[0];
            int v2=e[1];
            int time=e[2];
            mp.get(v1).add(new int[]{v2,time});
            mp.get(v2).add(new int[]{v1,time});
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new pair(0,0));
        pq.add(new pair(firstPerson,0));
        HashSet<Integer> st=new HashSet<>();
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            int vtx=rp.vtx;
            int time=rp.time;
            if(st.contains(vtx)){
                continue;
            }
            st.add(vtx);
            ans.add(vtx);

            for(int[] arr:mp.get(vtx)){
                int nbrs=arr[0];
                int ntime=arr[1];
                if(!st.contains(nbrs) && time<=ntime){
                    pq.add(new pair(nbrs,ntime));
                }
            }
        }
        return ans;

    }
    class pair{
        int vtx;
        int time;
        public pair(int vtx,int time){
            this.time=time;
            this.vtx=vtx;
        }
    }
}