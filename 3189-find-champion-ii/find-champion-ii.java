class Solution {
    HashMap<Integer,List<Integer>> mp;
    public int findChampion(int n, int[][] edges) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] e:edges){
            int v1=e[0];
            int v2=e[1];
            AddEdge(v1,v2);
        }
        int[] in=indegree();
        int c=0;
        int ans=-1;
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                ans=i;
                c++;
            }
            if(c>1){
                return -1;
            }
        }
        return ans;
    }
    public void AddEdge(int v1,int v2){
        mp.get(v1).add(v2);
    }
    public int[] indegree(){
        int[] in=new int[mp.size()];
        for(int v1:mp.keySet()){
            for(int v2:mp.get(v1)){
                in[v2]++;
            }
        }
        return in;
    }
}