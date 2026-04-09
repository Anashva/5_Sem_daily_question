class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i[]:dp){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        return memo(triangle,dp,0,0,n);

    }
    public int memo(List<List<Integer>> nums,int[][]dp,int i,int j,int n){
        if(j>n-1){
            return Integer.MAX_VALUE;
        }
        if(i==n-1){
            return nums.get(i).get(j);
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int top=nums.get(i).get(j)+memo(nums,dp,i+1,j,n);
        int bottom=nums.get(i).get(j)+memo(nums,dp,i+1,j+1,n);
        return dp[i][j]=Math.min(top,bottom);

    }
    
}