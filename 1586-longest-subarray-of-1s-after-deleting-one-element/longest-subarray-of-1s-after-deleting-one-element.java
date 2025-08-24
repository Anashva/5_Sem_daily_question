class Solution {
    public int longestSubarray(int[] nums) {
        int start=0;
        int end=0;
        int zero=0;
        int ans=0;
        while(end<nums.length){
            // grow
            if(nums[end]==0){
                zero++;
            }
            // shrink
            while(start<=end && zero>1){
                if(nums[start]==0){
                    zero--;
                }
                start++;
            }
            // answer update
            ans=Math.max(ans,end-start);
            end++;
        }
        return ans;
    }
}