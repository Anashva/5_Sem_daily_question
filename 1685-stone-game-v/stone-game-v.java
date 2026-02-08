class Solution {
    int[][] dp;
    public int stoneGameV(int[] stone) {
        int n=stone.length;
        int[] pre=new int[n+1];
        for(int i=0;i<stone.length;i++){
            pre[i+1]=pre[i]+stone[i];
        }
        dp=new int[n][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return game(pre,0,n-1);
    }
    public int game(int[] pre,int i,int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        for(int k=i;k<j;k++){
            int left=pre[k+1]-pre[i];//left part of stone
            int right=pre[j+1]-pre[k+1];//remaining part after left
            if(left>right){
                ans=Math.max(ans,right+game(pre,k+1,j));
            }
            else if(right>left){
                ans=Math.max(ans,left+game(pre,i,k));
            }
            else{
                ans=Math.max(ans,right+game(pre,k+1,j));
                ans=Math.max(ans,left+game(pre,i,k));
            }
        }
        return dp[i][j]=ans;
    }
}