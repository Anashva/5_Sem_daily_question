class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;//total subarray sum
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int min=minimum(nums);//minimum subarray sum
        int max=maximum(nums);//kedense subarray sum;
        if(total==min){
            return max;
        }
        return Math.max(max,total-min);
    }
    public int minimum(int[] nums){
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            min=Math.min(sum,min);
            if(sum>0){
                sum=0;
            }
        }
        return min;
    }
    public int maximum(int[] nums){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(sum,max);
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}