class Solution {
    static int MOD=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp=new int[m][n][maxMove+1];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return path(m,n,startRow,startColumn,maxMove,dp);
    }
    public static int path(int m,int n,int cr,int cc,int move,int[][][]dp){
        if(cr<0 || cr>=m || cc<0 || cc>=n){
            return 1;
        }
        if(move==0){
            return 0;
        }
        if(dp[cr][cc][move]!=-1){
            return dp[cr][cc][move];
        }
        long ans = 0;
        ans = (ans + path(m, n, cr, cc - 1, move - 1, dp)) % MOD;
        ans = (ans + path(m, n, cr, cc + 1, move - 1, dp)) % MOD;
        ans = (ans + path(m, n, cr - 1, cc, move - 1, dp)) % MOD;
        ans = (ans + path(m, n, cr + 1, cc, move - 1, dp)) % MOD;
        return dp[cr][cc][move]=(int)ans;
    }
}