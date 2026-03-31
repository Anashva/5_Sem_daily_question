class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp=new Integer[s.length()][t.length()];
        return coin(s,t,0,0);
    }
    public int coin(String s,String t,int i,int j){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int inc=0;
        if(s.charAt(i)==t.charAt(j)){
            inc=coin(s,t,i+1,j+1);
        }
        int exc=coin(s,t,i+1,j);
        return dp[i][j]=inc+exc;
    }
}