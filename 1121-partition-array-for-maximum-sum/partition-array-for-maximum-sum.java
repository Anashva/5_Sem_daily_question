class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int total=0;
        int n=arr.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=1;j<=k && i-j+1>=0 ;j++){
                max=Math.max(arr[i-j+1],max);
                int prev = (i - j >= 0) ? dp[i - j] : 0;
                dp[i]=Math.max(dp[i],prev+max*j);
            }
        }
        return dp[n-1];
    }
}