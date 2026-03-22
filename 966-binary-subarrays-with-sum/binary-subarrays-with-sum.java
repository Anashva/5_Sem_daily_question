class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums,goal)-count(nums,goal-1);
    }
    public int count(int[] nums,int goal){
        int end=0;
        int start=0;
        int ans=0;
        int sum=0;
        while(end<nums.length){
            sum+=nums[end];
            while(start<=end && sum>goal){
                sum-=nums[start];
                start++;
            }
            ans+=end-start+1;
            end++;
        }
        return ans;
    }
}