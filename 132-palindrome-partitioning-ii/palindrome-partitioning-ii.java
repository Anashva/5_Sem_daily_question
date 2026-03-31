class Solution {
    Integer[][] dp;
    public int minCut(String s) {
        dp=new Integer[s.length()][s.length()];
        return cut(s,0,s.length()-1);
    }
    public int cut(String s,int i,int j){
        if(i==j){
            return 0;
        }
        if(pall(s,i,j)){
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        int c=0;
        for(int k=i;k<j;k++){
            if(pall(s,i,k)){
                c=1+cut(s,k+1,j);
                ans=Math.min(ans,c);
            }
        }
        return dp[i][j]=ans;
    }
    public boolean pall(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}