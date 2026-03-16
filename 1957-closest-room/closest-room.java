class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int q=queries.length;
        int[] ans=new int[q];
        Arrays.fill(ans,-1);
        Query[] qr=new Query[q];
        for(int i=0;i<q;i++){
            qr[i]=new Query(queries[i][0],queries[i][1],i);
        }
        Arrays.sort(qr,(a,b)->b.msize-a.msize);
        Room[] rm=new Room[rooms.length];
        for(int i=0;i<rooms.length;i++){
            rm[i]=new Room(rooms[i][0],rooms[i][1]);
        }
        Arrays.sort(rm,(a,b)->b.size-a.size);
        int i=0;
        int min=Integer.MAX_VALUE;
        TreeSet<Integer> st=new TreeSet<>();
        for(Query qs:qr){
            while(i<rooms.length && rm[i].size>=qs.msize){
                st.add(rm[i].id);
                i++;
            }
            if(st.isEmpty()){
                ans[qs.idx]=-1;
                continue;
            }
            Integer floor=st.floor(qs.qid);
            Integer ceil=st.ceiling(qs.qid);
            if(floor==null){
                ans[qs.idx]=ceil;
            }
            else if(ceil==null){
                ans[qs.idx]=floor;
            }
            else{
                if(qs.qid-floor<=ceil-qs.qid){
                    ans[qs.idx]=floor;
                }
                else{
                    ans[qs.idx]=ceil;
                }
            }

        }
        return ans;
    }
    class Room{
        int id;
        int size;
        public Room(int id,int size){
            this.id=id;
            this.size=size;
        }
    }
    class Query{
        int qid;
        int msize;
        int idx;
        public Query(int qid,int msize,int idx){
            this.qid=qid;
            this.msize=msize;
            this.idx=idx;
        }
    }
}