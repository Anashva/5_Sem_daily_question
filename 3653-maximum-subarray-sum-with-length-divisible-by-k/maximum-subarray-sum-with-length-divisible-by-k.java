class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans=Long.MIN_VALUE;
        long[] pref=new long[k];
        Arrays.fill(pref,Long.MAX_VALUE/4);
        pref[0]=0;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int idx=(i+1)%k;
            ans=Math.max(ans,sum-pref[idx]);
            pref[idx]=Math.min(pref[idx],sum);
        }
        return ans;
    }
}