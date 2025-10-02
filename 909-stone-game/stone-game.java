class Solution {
    public boolean stoneGame(int[] piles) {
        // return  stone(piles,0,piles.length-1,true)>0;//alice socre-bob score
        int[][] dp=new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        TD(piles,0,piles.length-1,0,dp);
        return dp[0][piles.length-1]>0;
    }
    public int stone(int[] arr,int i,int j,boolean flag){
        if(i>j){
            return 0;
        }
        if(flag){
            int l=arr[i]+stone(arr,i+1,j,false);
            int r=arr[j]+stone(arr,i,j-1,false);
            return Math.max(l,r);
        }
        else{
            int l=stone(arr,i+1,j,true)-arr[i];
            int r=stone(arr,i,j-1,true)-arr[j];
            return Math.max(l,r);
        }

    }
    public int TD(int[] arr,int i,int j,int turn,int[][]dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return arr[i];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(turn==0){
            ans=Math.max(arr[i]+TD(arr,i+1,j,1,dp),arr[j]+TD(arr,i,j-1,1,dp));
        }
        else{
            ans=Math.max(TD(arr,i+1,j,0,dp)-arr[i],TD(arr,i,j-1,0,dp)-arr[j]);
        }
        return dp[i][j]=ans;
    }
}