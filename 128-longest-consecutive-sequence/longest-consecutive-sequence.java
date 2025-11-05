class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int ans=1;
        int c=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]==nums[i-1]+1){
                c++;
                ans=Math.max(ans,c);
            }
            else{
                c=1;
            }
        }
        return ans;
    }
}