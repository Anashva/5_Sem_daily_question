class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()][p.length()];
        return match(s,p,0,0);
    }
    public boolean match(String s,String p,int i,int j){
        if(i==s.length() && j==p.length()){
            return true;
        }
        if(j==p.length()){
            return false;
        }
        if(i==s.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }

        boolean f1=false;
        boolean f2=false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            f1=match(s,p,i+1,j+1);
        }
        else if(p.charAt(j)=='*'){
            f2=match(s,p,i,j+1) || match(s,p,i+1,j);
        }
        return dp[i][j]= f1 || f2;
    }
}