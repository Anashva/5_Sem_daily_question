class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int end=0;
        int start=0;
        int sum=0;
        while(end<nums.length){
            sum+=nums[end];
            while(sum>=target){
                ans=Math.min(end-start+1,ans);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return ans==Integer.MAX_VALUE ?0 :ans;
    }
}