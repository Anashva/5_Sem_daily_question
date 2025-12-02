class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr=new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=1;i<arr.length-1;i++){
            arr[i]=cuts[i-1];
        }
        int[][] dp=new int[arr.length][arr.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return cost(arr,0,arr.length-1,dp);
    }
    public int cost(int[] arr,int i,int j,int[][]dp){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int l=cost(arr,i,k,dp);
            int r=cost(arr,k,j,dp);
            int self=(arr[j]-arr[i]);
            ans=Math.min(ans,l+r+self);
        }
        return dp[i][j]=ans;
    }
}

// each smaller stick has fewer cuts 
// minimum cost for cut to stick btwn i and j
