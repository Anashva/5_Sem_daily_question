class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return rollBU(n,k,target);
    }
    public int roll(int n,int k,int target){
        if(target<0){
            return 0;
        }
        if(target==0 && n==0) {
            return 1;
        }
        if (n != 0 && target == 0){
            return 0;
        }
        if(target!=0 && n==0){
            return 0;
        }

        int ans=0;
        for(int i=1;i<=k;i++){
            if(target>=i){
                ans+=roll(n-1,k,target-i);
            }
        }
        return ans;
    }
    public int rollTD(int n,int k,int target,int[][] dp){
        if(target<0){
            return 0;
        }
        if(target==0 && n==0) {
            return 1;
        }
        if (n != 0 && target == 0){
            return 0;
        }
        if(target!=0 && n==0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int ans=0;
        for(int i=1;i<=k;i++){
            if(target>=i){
                ans+=roll(n-1,k,target-i);
            }
        }
        return dp[n][target]=ans;
    }
    public int rollBU(int n,int k,int target){
        int[][] dp=new int[n+1][target+1];
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=target;j>0;j--){
                int ans=0;
                for(int m=1;m<=k;m++){
                    if(j-m>=0){
                        dp[i][j]=(dp[i][j]+dp[i-1][j-m])%mod;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    
}