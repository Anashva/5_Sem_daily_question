class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k)-count(nums,k-1);
    }
    public static int count(int[] nums,int k){
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        int start=0;
        int end=0;
        while(end<nums.length){
            mp.put(nums[end],mp.getOrDefault(nums[end],0)+1);
            while(mp.size()>k){
                mp.put(nums[start],mp.get(nums[start])-1);
                if(mp.get(nums[start])==0){
                    mp.remove(nums[start]);
                }
                start++;
            }
            ans+=end-start+1;
            end++;
        }
        return ans;
    }
}