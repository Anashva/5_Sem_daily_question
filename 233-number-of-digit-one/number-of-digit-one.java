class Solution {
    public int countDigitOne(int n) {
        String s=Integer.toString(n);
        int[][][] dp=new int[11][2][10];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(s,0,1,0,dp);
    }
    public int solve(String s,int idx,int tight,int cnt1,int[][][] dp){
        if(idx==s.length()){
            return cnt1;
        }
        if(dp[idx][tight][cnt1]!=-1){
            return dp[idx][tight][cnt1];
        }
        int lb=0;
        int ub=(tight==1) ?s.charAt(idx)-'0' :9;

        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            int cnt=dig==1 ?1 :0;
            res+=solve(s,idx+1,(tight==1 && dig==ub)? 1:0,cnt1+ cnt,dp);
        }
        return dp[idx][tight][cnt1]=res;
    }
}