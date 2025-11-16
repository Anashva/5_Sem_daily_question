class Solution {
    int mod=1000000007;
    public int numberOfArrays(String s, int k) {
        // return number(s,k,0);
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return TD(s,k,0,dp);
    }
    public int number(String s,int k,int idx){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }
        int ans=0;
        int num=0;
        for(int i=idx;i<s.length();i++){
            num=num*10+(s.charAt(i)-'0');
            if(num>k){
                break;
            }
            int c=number(s,k,i+1);
            ans=(ans+c)%mod;
        }
        return ans;
    }
    public int TD(String s,int k,int idx,int[]dp){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=0;
        long num=0;
        for(int i=idx;i<s.length();i++){
            num=num*10+(s.charAt(i)-'0');
            if(num>k){
                break;
            }
            int c=TD(s,k,i+1,dp);
            ans=(ans+c)%mod;
        }
        return dp[idx]=ans;
    }
}