class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long[] pref=new long[nums.length+1];
        HashMap<Integer,Long> mp=new HashMap<>();
        long ans=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            pref[i+1]=pref[i]+nums[i];
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],pref[i]);
            }
            else{
                mp.put(nums[i],Math.min(pref[i],mp.get(nums[i])));
            }
            if(mp.containsKey(nums[i]-k)){
                ans=Math.max(ans,pref[i+1]-mp.get(nums[i]-k));
            }
            if(mp.containsKey(nums[i]+k)){
                ans=Math.max(ans,pref[i+1]-mp.get(nums[i]+k));
            }
        }
        return ans==Long.MIN_VALUE ? 0:ans;
    }
}