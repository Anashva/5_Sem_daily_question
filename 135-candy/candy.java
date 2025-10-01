class Solution {
    public int candy(int[] nums) {
        int[] ans=new int[nums.length];
        Arrays.fill(ans,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                ans[i]=ans[i-1]+1;
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]<nums[i]){
                ans[i]=Math.max(ans[i],ans[i+1]+1);
            }
        }
        int c=0;
        for(int i=0;i<nums.length;i++){
            c+=ans[i];
        }
        return c;
    }
}