class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> ll=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(ll,ans,graph,0);
        return ans;
    }
    public void dfs(List<Integer> ll,List<List<Integer>> ans,int[][] graph,int vtx){
        if(vtx==graph.length-1){
            ll.add(vtx);
            ans.add(new ArrayList<>(ll));
            ll.remove(ll.size()-1);
            return;
        }
        ll.add(vtx);
        for(int nbrs:graph[vtx]){
            dfs(ll,ans,graph,nbrs);
        }
        ll.remove(ll.size()-1);
    }
}