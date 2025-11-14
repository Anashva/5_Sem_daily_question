class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[][] dp=new Boolean[n+1][2];
        return winner(n,true,dp);
    }
    public boolean winner(int n,boolean turn,Boolean[][] dp){
        if(n==0){
            return false;
        }
        int t=turn ? 1 :0;
        if(dp[n][t]!=null){
            return dp[n][t];
        }
        double x=Math.sqrt(n);
        boolean f1=false;
        boolean f2=false;
        if(turn){
            if((int)x*(int)x==n){
                dp[n][t]=true;
                return true;
            }
            else{
                for(int k=1;k<=(int)x;k++){
                    if(!winner(n-k*k,false,dp)){
                        f1=true;
                        break;
                    }
                }
            }
            dp[n][t]=f1;
            return f1;
        }
        else{
            if((int)x*(int)x==n){
                dp[n][t]=true;
                return true;
            }
            else{
                for(int k=1;k<=(int)x;k++){
                    if(!winner(n-k*k,true,dp)){
                        f2=true;
                        break;
                    }
                }
            }
            dp[n][t]=f2;
            return f2;
        }     
    }
}