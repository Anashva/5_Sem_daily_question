class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int q=queries.length;
        int n=intervals.length;
        Query[] qr=new Query[q];
        for(int i=0;i<q;i++){
            qr[i]=new Query(queries[i],i);
        }
        Arrays.sort(qr,(a,b)->a.q-b.q);
        Pair[] rp=new Pair[n];
        for(int i=0;i<n;i++){
            rp[i]=new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(rp,(a,b)->a.li-b.li);
        int j=0;
        int[] res=new int[q];
        Arrays.fill(res,-1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);//adding minimum size and right of interval 
        for(Query qs:qr){
            while(j<n && rp[j].li<=qs.q){
                int size=rp[j].ri-rp[j].li+1;
                pq.add(new int[]{size,rp[j].ri});
                j++;
            }
            while(!pq.isEmpty() && qs.q>pq.peek()[1]){
                pq.poll();
            }
            if(!pq.isEmpty()){
                res[qs.idx]=pq.peek()[0];
            }
        }
        return res;

    }
    class Query{
        int q;
        int idx;
        public Query(int q,int idx){
            this.q=q;
            this.idx=idx;
        }
    }
    class Pair{
        int li;
        int ri;
        public Pair(int li,int ri){
            this.li=li;
            this.ri=ri;
        }
    }
}