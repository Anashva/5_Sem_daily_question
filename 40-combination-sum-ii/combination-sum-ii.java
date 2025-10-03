class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        sum(candidates,0,target,ans,ll);
        return ans;
    }
    public void sum(int[] arr,int idx,int target,List<List<Integer>> ans,List<Integer> ll){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            if(target>=arr[i]){
                    ll.add(arr[i]);
                    sum(arr,i+1,target-arr[i],ans,ll);
                    ll.remove(ll.get(ll.size()-1));
            }
        }
    }
}