class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        // int ans=Math.max(robber(nums,0,nums.length-2),robber(nums,1,nums.length-1));
        // return ans;

        int[] dp = new int[nums.length];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);
        return Math.max(robber2(nums,dp,0,nums.length-2),robber2(nums,dp1,1,nums.length-1));
    }
    public int robber2(int[] arr,int[]dp,int si,int ei){
        if(si==ei){
            return arr[si];
        }
        if(si>ei){
            return 0;
        }
        if(dp[si]!=-1){
            return dp[si];
        }
        int rob=arr[si]+robber2(arr,dp,si+2,ei);
        int nrob=robber2(arr,dp,si+1,ei);
        return dp[si]=Math.max(rob,nrob);
    }
    // public int rob(int[] nums) {
    //     if(nums.length==1){
    //         return nums[0];
    //     }
    //     int ans=Math.max(robber(nums,0,nums.length-2),robber(nums,1,nums.length-1));
    //     return ans;
    // }
    //  public static int robber(int[] nums, int start, int end) {
    //     int[] num = new int[nums.length];        
    //     num[start] = nums[start]; 
    //     if (start + 1 <= end) {
    //         num[start + 1] = Math.max(nums[start], nums[start + 1]);  
    //     }
    //     for (int i = start + 2; i <= end; i++) {
    //         int s = nums[i] + num[i - 2];
    //         num[i] = Math.max(num[i - 1], s);
    //     }
    //     return num[end]; 
    // }

}