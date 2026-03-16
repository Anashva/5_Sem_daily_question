class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int q=queries.length;
        int[] ans=new int[q];
        Query[] qr=new Query[q];
        for(int i=0;i<q;i++){
            qr[i]=new Query(queries[i],i);
        }
        Pair[] rp=new Pair[items.length];
        for(int i=0;i<items.length;i++){
            rp[i]=new Pair(items[i][0],items[i][1]);
        }
        Arrays.sort(qr,(a,b)->a.val-b.val);
        Arrays.sort(rp,(a,b)->a.p-b.p);
        int i=0;
        int max=0;
        for(Query qs:qr){
            while(i<items.length && rp[i].p<=qs.val){
                max=Math.max(max,rp[i].q);
                i++;
            }
            ans[qs.idx]=max;
        }
        return ans;
    }
    class Pair{
        int p;
        int q;
        public Pair(int p,int q){
            this.p=p;
            this.q=q;
        }
    }
    class Query{
        int val;
        int idx;
        public Query(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
}