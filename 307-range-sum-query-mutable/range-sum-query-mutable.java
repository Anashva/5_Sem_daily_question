class NumArray {
    segmentTree st;
    public NumArray(int[] nums) {
        st=new segmentTree(nums);
    }
    
    public void update(int index, int val) {
        st.updte(0,0,st.n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return (int)st.query(0,0,st.n-1,left,right);
    }
    class segmentTree{
        int n;
        long [] tree;
        segmentTree(int[] arr){
            n=arr.length;
            tree=new long[4*n];
            build(0,0,n-1,arr);
        }
        public void build(int node,int start,int end,int[] arr){
            if(start==end){
                tree[node]=arr[start];
                return;
            }
            int mid=(start+end)/2;
            build(2*node+1,start,mid,arr);
            build(2*node+2,mid+1,end,arr);
            tree[node]=tree[2*node+1]+tree[2*node+2];
        }
        public void updte(int node,int start,int end,int idx,int val){
            if(start==end){
                tree[node]=val;
                return;
            }
            int mid=(start+end)/2;
            if(idx<=mid){
                updte(2*node+1,start,mid,idx,val);
            }
            else{
                updte(2*node+2,mid+1,end,idx,val);
            }
            tree[node]=tree[2*node+1]+tree[2*node+2];
        }
        public long query(int node,int start,int end,int l,int r){
            if(r<start || end<l){
                return 0;
            }
            if(l<=start && end<=r){
                return tree[node];
            }
            int mid=(start+end)/2;
            long left=query(2*node+1,start,mid,l,r);
            long right=query(2*node+2,mid+1,end,l,r);
            return left+right;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */