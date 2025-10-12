class Solution {
    int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        int[][] dp=new int[Math.min(steps,arrLen)][steps+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return way(steps,0,Math.min(steps,arrLen),dp);
    }
    public int way(int k,int pos,int arrLen,int[][]dp){
        if(pos<0 || pos>=arrLen){
            return 0;
        }
        if(k==0){
            if(pos==0){
                return 1;
            }
            return 0;
        }
        if(dp[pos][k]!=-1){
            return dp[pos][k];
        }
        int same=way(k-1,pos,arrLen,dp);
        int l=way(k-1,pos-1,arrLen,dp);
        int r=way(k-1,pos+1,arrLen,dp);
        return dp[pos][k]=(int)(((long)same + l+ r) % MOD);
    }
}