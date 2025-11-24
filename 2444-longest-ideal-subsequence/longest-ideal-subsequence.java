class Solution {
    public int longestIdealString(String s, int k) {
        int[][] dp=new int[s.length()+1][150];// 150 isliye liye h ki char ki ascii value max 150 tk ho skta h
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return longest(0,s,k,dp,'#');//# taken because prevously no character is there for dummy taken
    }
    public int longest(int idx,String s,int k,int[][] dp,char ch){
        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx][ch]!=-1){
            return dp[idx][ch];
        }
        int ans=0;
        if(Math.abs(ch-s.charAt(idx))<=k || ch=='#'){//1 char ko hmesa allow krega lene k liye
            ans=1+longest(idx+1,s,k,dp,s.charAt(idx));
        }
        int np=longest(idx+1,s,k,dp,ch);
        return dp[idx][ch]=Math.max(ans,np);
    }
}