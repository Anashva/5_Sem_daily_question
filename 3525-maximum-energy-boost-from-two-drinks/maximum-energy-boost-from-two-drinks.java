class Solution {
    long[][] dp;
    public long maxEnergyBoost(int[] A, int[] B) {
        dp=new long[A.length][2];
        for(long[] a:dp){
            Arrays.fill(a,-1);
        }
        return Math.max(count(A,B,0,1),count(A,B,0,0));
    }
    public long count(int[] a,int [] b,int i,int turn){
        if(i>=a.length){
            return 0;
        }
        if(dp[i][turn]!=-1){
            return dp[i][turn];
        }
        long ans=0;
        if(turn==1){
            ans=a[i]+Math.max(count(a,b,i+1,1),count(a,b,i+2,0));
        }
        else{
            ans=b[i]+Math.max(count(a,b,i+2,1),count(a,b,i+1,0));
        }
        return dp[i][turn]=ans;
    }
}