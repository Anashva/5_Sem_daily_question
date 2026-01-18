class Solution {
    public int minSwapsCouples(int[] arr) {
        int n=arr.length/2;;
        DSU dsu=new DSU(n);
        for(int i=0;i<n*2;i+=2){
            dsu.union(arr[i]/2,arr[i+1]/2);
        }
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(dsu.find(i));
        }
        return n-st.size();
    }
    class DSU{
        int[] parent;
        DSU(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int x){
            if(parent[x]==x){
                return x;
            }
            parent[x]=find(parent[x]);
            return parent[x];
        }
        public void union(int x,int y){
            int rx=find(x);
            int ry=find(y);
            if(rx!=ry){
                parent[rx]=ry;
            }
        }
    }
}