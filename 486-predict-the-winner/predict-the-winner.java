class Solution {
    public boolean predictTheWinner(int[] nums) {
        // return winner(nums,0,nums.length-1,1,0,0);
        int [][] dp=new int [nums.length][nums.length];
        for(int [] arr:dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        return TD(nums,0,nums.length-1,dp)>=0;
    }
    public int TD(int[] nums,int i,int j,int [][] dp){
        if(i==j){
            return nums[i];
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int l=nums[i]-TD(nums,i+1,j,dp);
        int r=nums[j]-TD(nums,i,j-1,dp);
        return dp[i][j]=Math.max(l,r);
    }
    public boolean winner(int[] nums,int i,int j,int turn,int p1,int p2){
        if(i>j){
            return p1>=p2;
        }
        if(turn==1){
            return winner(nums,i+1,j,0,p1+nums[i],p2) || winner(nums,i,j-1,0,p1+nums[j],p2);
        }
        else{
            return winner(nums,i+1,j,1,p1,nums[i]+p2) && winner(nums,i,j-1,1,p1,nums[j]+p2);
        }
    }
}