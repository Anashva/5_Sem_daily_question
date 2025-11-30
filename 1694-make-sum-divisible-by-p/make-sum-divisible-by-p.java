class Solution {
    public int minSubarray(int[] nums, int p) {
        long[] pref=new long[nums.length];
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i]=pref[i-1]+nums[i];
        }
        HashMap<Long,Integer> mp=new HashMap<>();
        mp.put(0l,-1);
        long total=pref[nums.length-1];
        if(total%p==0){
            return 0;
        }
        int ans=nums.length;
        for(int i=0;i<nums.length;i++){
            long d=(pref[i]-total%p+p)%p;//(pref[i] - subarraySum) % p == total % p
            if(mp.containsKey(d)){
                ans=Math.min(ans,i-mp.get(d));
            }
            mp.put(pref[i]%p,i);

        }
        return ans==nums.length ? -1:ans;

    }
}