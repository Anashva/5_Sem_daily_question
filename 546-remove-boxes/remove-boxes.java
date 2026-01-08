class Solution {
    public int removeBoxes(int[] nums) {
        int n=nums.length;
        int[][][] dp=new int[n][n][n];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return remove(nums,0,n-1,0,dp);
    }
    public int remove(int[] nums,int l,int r,int k,int[][][]dp){
        if(l>r){
            return 0;
        }
        if(dp[l][r][k]!=-1){
            return dp[l][r][k];
        }
        int ans=(k+1)*(k+1)+remove(nums,l+1,r,0,dp);
        for(int m=l+1;m<=r;m++){
            if(nums[l]==nums[m]){
                ans=Math.max(ans,remove(nums,l+1,m-1,0,dp)+remove(nums,m,r,k+1,dp));
            }
        }
        return dp[l][r][k]=ans;
    }
}