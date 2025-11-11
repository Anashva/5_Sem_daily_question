class Solution {
    int[] count=new int[2];
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp=new int[strs.length][m+1][n+1];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return count(strs,0,m,n,dp);
        
    }
    public int count(String[] strs,int idx,int m,int n,int[][][] dp){
        if(idx>=strs.length){
            return 0;
        }
        if(dp[idx][m][n]!=-1){
            return dp[idx][m][n];
        }
        int take=0;
        if(valid(strs[idx],m,n)){
            take=1+count(strs,idx+1,m-count[0],n-count[1],dp);
        }
        int skip=count(strs,idx+1,m,n,dp);
        return dp[idx][m][n]=Math.max(skip,take);
    }
    public boolean valid(String s,int m,int n){
        int one=0;
        int zero=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zero++;
            }
            else{
                one++;
            }
        }
        count[0]=zero;
        count[1]=one;
        return zero<=m && one<=n;
    }
}