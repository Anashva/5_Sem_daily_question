class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int[] sort=nums.clone();
        Arrays.sort(sort);
        HashMap<Integer,Integer> rank=new HashMap<>();
        int idx=0;

        // coordinate compression
        for(int num:sort){
            if(!rank.containsKey(num)){
                rank.put(num,idx++);
            }
        }
        SegmentTree st=new SegmentTree(idx);
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            int r=rank.get(nums[i]);
            if(r>0){
                ans[i]=st.query(0,0,idx-1,0,r-1);
            }
            else{
                ans[i]=0;
            }
            st.update(0,0,idx-1,r);
        }
        List<Integer> res=new ArrayList<>();
        for(int num:ans){
            res.add(num);
        }
        return res;

    }
    class SegmentTree{
        int n;
        int[] tree;
        SegmentTree(int n){
            this.n=n;
            tree=new int[4*n];
        }
        public void update(int node,int start,int end,int pos){
            if(start==end){
                tree[node]+=1;
                return;
            }
            int mid=(start+end)/2;
            if(pos<=mid){
                update(2*node+1,start,mid,pos);
            }
            else{
                update(2*node+2,mid+1,end,pos);
            }
            tree[node]=tree[2*node+1]+tree[2*node+2];
        }

        public int query(int node,int start,int end,int l,int r){
            if(r<start || end<l){
                return 0;
            }
            if(l<=start && end<=r){
                return tree[node];
            }
            int mid=(start+end)/2;
            return query(2*node+1,start,mid,l,r)+query(2*node+2,mid+1,end,l,r);
        }
    }
}