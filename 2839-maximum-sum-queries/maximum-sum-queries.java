class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int q=queries.length;
        Query[] qr=new Query[q];
        for(int i=0;i<q;i++){
            qr[i]=new Query(queries[i][0],queries[i][1],i);
        }
        Arrays.sort(qr,(a,b)->b.x-a.x);
        Pair[] rp=new Pair[nums1.length];
        for(int i=0;i<nums1.length;i++){
            rp[i]=new Pair(nums1[i],nums2[i],nums1[i]+nums2[i]);
        }
        Arrays.sort(rp,(a,b)->(b.x1-a.x1));
        int[] ans=new int[q];
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        int j=0;
        int n=nums1.length;
        for(int i=0;i<q;i++){
            while(j<n && rp[j].x1>=qr[i].x){
                int b=rp[j].y1;
                int sum=rp[j].sum;
                var next=mp.ceilingKey(b);
                if(next==null || mp.get(next)<sum){
                    var prev= mp.floorEntry(b);
                    while(prev!=null && prev.getValue()<=sum){
                        mp.remove(prev.getKey());
                        prev=mp.floorEntry(b);
                    }
                    mp.put(b,sum);
                }
                j++;
            }
            Integer key=mp.ceilingKey(qr[i].y);
            if(key!=null){
                ans[qr[i].idx]=mp.get(key);
            }
            else{
                ans[qr[i].idx]=-1;
            }
        }
        return ans;

    }

    class Pair{
        int x1;
        int y1;
        int sum;
        public Pair(int x1,int y1,int sum){
            this.x1=x1;
            this.y1=y1;
            this.sum=sum;
        }
    }

    class Query{
        int x;
        int y;
        int idx;
        public Query(int x,int y,int idx){
            this.x=x;
            this.y=y;
            this.idx=idx;
        }
    }
}