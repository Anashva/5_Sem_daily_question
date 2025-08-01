class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int even=0;
        int odd=0;
        for(int i=0;i<nums.length;i++){
            int min=Integer.MAX_VALUE;
            if(i-1>=0){
                if(nums[i-1]<=nums[i]){
                    min=Math.min(min,nums[i-1]);
                }
            }
            if(i+1<nums.length){
                if(nums[i+1]<=nums[i]){
                    min=Math.min(min,nums[i+1]);
                }
            }
            int diff=nums[i]-min+1;
            if (min != Integer.MAX_VALUE){
            if(i%2==0){
                even+=diff;
            }
            else{
                odd+=diff;
            }
            }
        }
        return Math.min(odd,even);
    }
    
}