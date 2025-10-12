class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] prefix=new long[nums.length];
        prefix[0]=nums[0];
        long ans=0;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=nums.length-1;i>=2;i--){
            if(prefix[i-1]>nums[i]){
                return prefix[i];
            }
        }
        return -1;
    }
}