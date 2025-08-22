class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarr(nums,k)-subarr(nums,k-1);
    }
    public int subarr(int[] nums,int k){
        int start=0;
        int end=0;
        int ans=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        while(end<nums.length){
            mp.put(nums[end],mp.getOrDefault(nums[end],0)+1);
            while(mp.size()>k){
                mp.put(nums[start],mp.get(nums[start])-1);
                if(mp.get(nums[start])==0){
                    mp.remove(nums[start]);
                }
                start++;
            }
            ans+=(end-start+1);
            end++;
        }
        return ans;
    }
}