class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[i]){
                    dp1[i]=Math.max(dp1[i],dp2[j]+1);
                }
                if(nums[j]<nums[i]){
                    dp2[i]=Math.max(dp2[i],dp1[j]+1);
                }
            }
        }
        return Math.max(dp1[n-1],dp2[n-1]);
    }
}