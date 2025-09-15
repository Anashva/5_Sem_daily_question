class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp=new double[n][n][k+1];
        for(double [][] a:dp){
            for(double[] arr:a){
                Arrays.fill(arr,-1.0);
            }
        }
        return knight(n,row,column,k,dp);
    }
    public double knight(int n,int cr,int cc,int k,double[][][]dp){
        if(cr<0 || cr>=n || cc<0 || cc>=n){
            return 0.0;
        }
        if(k==0){
            return 1.0;
        }
        if(dp[cr][cc][k]!=-1.0){
            return dp[cr][cc][k];
        }
        double ans=0;
        ans=ans+knight(n,cr+2,cc+1,k-1,dp);
        ans=ans+knight(n,cr+2,cc-1,k-1,dp);
        ans=ans+knight(n,cr-2,cc+1,k-1,dp);
        ans=ans+knight(n,cr-2,cc-1,k-1,dp);
        ans=ans+knight(n,cr+1,cc+2,k-1,dp);
        ans=ans+knight(n,cr-1,cc+2,k-1,dp);
        ans=ans+knight(n,cr+1,cc-2,k-1,dp);
        ans=ans+knight(n,cr-1,cc-2,k-1,dp);
        dp[cr][cc][k]=ans/8.0;
        return dp[cr][cc][k];
    }

}