class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        subset(nums,ans,ll,0);
        return ans;
    }
    public void subset(int[] nums,List<List<Integer>> ans,List<Integer> ll,int idx){
        ans.add(new ArrayList<>(ll));
        for(int i=idx;i<nums.length;i++){
            ll.add(nums[i]);
            subset(nums,ans,ll,i+1);
            ll.remove(ll.get(ll.size()-1));
        }
    }
}