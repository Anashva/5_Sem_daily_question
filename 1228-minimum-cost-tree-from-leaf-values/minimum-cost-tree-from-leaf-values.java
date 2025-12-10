class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp=new int[arr.length][arr.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return mcm(arr,0,arr.length-1,dp);
    }
    public int mcm(int[] arr,int i,int j,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int l=mcm(arr,i,k,dp);
            int r=mcm(arr,k+1,j,dp);
            int maxl=0;
            int maxr=0;
            for(int p=i;p<=k;p++){
                maxl=Math.max(maxl,arr[p]);
            }
            for(int p=k+1;p<=j;p++){
                maxr=Math.max(maxr,arr[p]);
            }
            ans=Math.min(ans,l+r+(maxr*maxl));
        }
        return dp[i][j]=ans;
    }
}