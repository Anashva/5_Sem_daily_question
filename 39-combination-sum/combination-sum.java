class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        sum(candidates,ans,ll,0,target);
        return ans;
    }
    public void sum(int[] nums,List<List<Integer>> ans,List<Integer> ll,int idx,int target){
        if(target==0){
            ans.add(new ArrayList<>(ll));
        }
        for(int i=idx;i<nums.length;i++){
            if(target>=nums[i]){
                ll.add(nums[i]);
                sum(nums,ans,ll,i,target-nums[i]);
                ll.remove(ll.get(ll.size()-1));
            }
        }
    }
}