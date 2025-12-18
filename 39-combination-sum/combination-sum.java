class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        comb(candidates,target,0,res,ll);
        return res;
    }
    public void comb(int[] arr,int target,int idx,List<List<Integer>> res,List<Integer> ll){
        if(target==0){
            res.add(new ArrayList<>(ll));
        }
        for(int i=idx;i<arr.length;i++){
            if(target>=arr[i]){
                ll.add(arr[i]);
                comb(arr,target-arr[i],i,res,ll);
                ll.remove(ll.get(ll.size()-1));
            }
        }
    }
}