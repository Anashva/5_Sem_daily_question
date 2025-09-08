class Solution {
    public String getPermutation(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean[] visit=new boolean[n];
        permute(ans,visit,ll,n,0);
        StringBuilder sb=new StringBuilder();
        List<Integer> res=ans.get(k-1);
        for(int i:res){
            sb.append(i);
        }
        return sb.toString();
    }
    public void permute(List<List<Integer>> ans,boolean[] visit,List<Integer> ll,int n,int idx){
        if(idx==n){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                ll.add(i+1);
                permute(ans,visit,ll,n,idx+1);
                ll.remove(ll.size()-1);
                visit[i]=false;
            }
        }
    }
}