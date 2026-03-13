class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ll=new ArrayList<>();
        int[] in=new int[n];
        for(List<Integer> e:edges){
            int u=e.get(0);
            int v=e.get(1);
            in[v]++;
        }
        for(int i=0;i<n;i++){
            if(in[i]==0){
                ll.add(i);
            }
        }
        return ll;
    }
}