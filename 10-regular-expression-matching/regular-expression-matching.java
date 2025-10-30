class Solution {
    public boolean isMatch(String s, String p) {
        // return expr(s,p,0,0);
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return TD(s,p,0,0,dp);
    }
    public boolean expr(String s,String p,int i,int j){
        if(i==s.length() && j==p.length()){
            return true;
        }
        if(j==p.length()){
            return false;
        }
        if(i==s.length()){
            while(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                j=j+2;
            }
            return j==p.length();
        }

        boolean ans=(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            return expr(s,p,i,j+2) || (ans && expr(s,p,i+1,j));
        }
        else{
            if(ans){
                return expr(s,p,i+1,j+1);
            }
            else{
                return false;
            }
        }
    }
    public boolean TD(String s,String p,int i,int j,Boolean[][]dp){
        if(i==s.length() && j==p.length()){
            return true;
        }
        if(j==p.length()){
            return false;
        }
        if (dp[i][j] != null){ 
            return dp[i][j];
        }

        if(i==s.length()){
            while(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                j=j+2;
            }
            return dp[i][j]=(j==p.length());
        }

        boolean ans=(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            dp[i][j]= TD(s,p,i,j+2,dp) || (ans && TD(s,p,i+1,j,dp));
            return dp[i][j];
        }
        else{
            if(ans){
                dp[i][j]=TD(s,p,i+1,j+1,dp);
            }
            else{
                dp[i][j]=false;
            }
        }
        return dp[i][j];
    }
}