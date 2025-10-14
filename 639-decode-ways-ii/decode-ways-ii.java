class Solution {
    int MOD=1000000007;
    public int numDecodings(String s) {
        long[] dp=new long[s.length()];
        Arrays.fill(dp,-1);
        return (int)count(s,0,dp);
    }
    public long count(String s,int i,long[] dp){
        if(s.length()==i){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        char ch=s.charAt(i);
        long ans=0;
        // single char k liye
        if(ch=='*'){
            ans=(9*count(s,i+1,dp))%MOD;
        }
        else {
            ans=count(s,i+1,dp)%MOD;
        }
        // double char k liye
        if(s.length()>i+1){
            char ch1=s.charAt(i+1);
            if(ch=='1'){
                if(ch1=='*'){
                    ans=(ans+9*count(s,i+2,dp))%MOD;//11-19
                }
                else{
                    ans=(ans+count(s,i+2,dp))%MOD;
                }
            }
            else if(ch=='2'){
                if(ch1=='*'){
                    ans=(ans+6*count(s,i+2,dp))%MOD;//21-26
                }
                else if(ch1>='0' && ch1<='6'){
                    ans=(ans+count(s,i+2,dp))%MOD;
                }
            }
            else if(ch=='*'){
                if(ch1=='*'){
                    // 11–19 and 21–26
                    ans=(ans+15*count(s,i+2,dp))%MOD;
                }
                else if(ch1>='0' && ch1<='6'){
                    ans=(ans+2*count(s,i+2,dp))%MOD;//1 ans 2*
                }
                else{
                    ans=(ans+count(s,i+2,dp))%MOD;//1*
                }
            }
        }

        return dp[i]=ans%MOD;

    }
}