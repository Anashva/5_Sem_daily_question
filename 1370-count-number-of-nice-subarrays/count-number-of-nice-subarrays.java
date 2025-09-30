class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return nice(nums,k)-nice(nums,k-1);
    }
    public int nice(int[] nums,int k){
        int end=0;
        int start=0;
        int ans=0;
        int odd=0;
        while(end<nums.length){
            if(nums[end]%2==1){
                odd++;
            }
            while(odd>k){
                if(nums[start]%2==1){
                    odd--;
                }
                start++;
            }
            ans+=end-start+1;
            end++;
        }
        return ans;
    }
}