class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return count(s,0,dp);
    }
    public int count(String s,int i,int[]dp){
        if(s.length()==i){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int a=0,b=0;
        b=count(s,i+1,dp);
        if(s.length()>i+1){
            int n=Integer.parseInt(s.substring(i,i+2));
            if(n>=10 && n<=26){
                a=count(s,i+2,dp);
            }
        }
        return dp[i]=a+b;
    }
}