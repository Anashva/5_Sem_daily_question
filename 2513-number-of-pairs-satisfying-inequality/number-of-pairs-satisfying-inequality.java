class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        long ans=0;
        int n=nums1.length;
        int[] arr=new int[n];
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=nums1[i]-nums2[i];
        }
        TreeSet<Integer> set=new TreeSet<>();
        for(int x:arr){
            set.add(x);
            set.add(x-diff);
        }
        List<Integer> ll=new ArrayList<>(set);
        for(int i=0;i<ll.size();i++){
            mp.put(ll.get(i),i);
        }
        SegmentTree st=new SegmentTree(ll.size());
        for(int i=n-1;i>=0;i--){
            int idx=mp.get(arr[i]-diff);
            ans+=st.query(1,0,ll.size()-1,idx,ll.size()-1);
            st.update(1,0,ll.size()-1,1,mp.get(arr[i]));
        }
        return ans;
    }
    static class SegmentTree{
        long [] tree;
        public SegmentTree(int n){
            tree=new long[4*n];
        }
        public long query(int node,int left,int right,int l, int r){
            if(r<left || l>right){
                return 0;
            }
            if(l<=left && r>=right){
                return tree[node];
            }
            int mid=(left+right)/2;
            long lft=query(2*node,left,mid,l,r);
            long rght=query(2*node+1,mid+1,right,l,r);
            return lft+rght;

        }
        public void update(int node,int left,int right,int val,int pos){
            if(left==right){
                tree[node]+=val;
                return;
            }
            int mid=(left+right)/2;
            if(mid>=pos){
                update(2*node,left,mid,val,pos);
            }
            else{
                update(2*node+1,mid+1,right,val,pos);
            }
            tree[node]=tree[2*node]+tree[2*node+1];
        }
    }
}