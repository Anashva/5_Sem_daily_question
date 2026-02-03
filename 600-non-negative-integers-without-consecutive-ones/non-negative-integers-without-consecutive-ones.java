class Solution {
    int[][][] dp;
    public int findIntegers(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int r=n%2;
            sb.append(""+r);
            n/=2;
        }
        String s=sb.reverse().toString();
        dp=new int[32][2][2];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return solve(s,0,1,0);
    }
    public int solve(String s,int idx,int tight,int prev){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][prev]!=-1){
            return dp[idx][tight][prev];
        }
        
        int lb=0;
        int ub=tight==1 ? s.charAt(idx)-'0' :1;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            if(digit==1 && prev==1){
                continue;
            }
            int newt=(tight==1 && digit==ub) ? 1:0;
            ans+=solve(s,idx+1,newt,digit);
        }
        return dp[idx][tight][prev]=ans;
    }
}