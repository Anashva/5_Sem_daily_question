class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans=0;
        int prev=-1;
        int curr=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>right){
                prev=i;
            }
            if(nums[i]>=left && nums[i]<=right){
                curr=i;
            }
            if(curr!=-1){
                ans+=Math.max(0,curr-prev);
            }
        }
        return ans;
    }
}