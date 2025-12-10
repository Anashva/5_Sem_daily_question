class Solution {
    public int minCut(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return mcm(s,0,s.length()-1,dp);
    }
    public int mcm(String s,int i,int j,int[][]dp){
        if(i==j){
            return 0;
        }
        if(pallindrome(s,i,j)){
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        int c=0;
        for(int k=i;k<j;k++){
            if(pallindrome(s,i,k)){
                c=1+mcm(s,k+1,j,dp);
                ans=Math.min(ans,c);
            }
        }
        return dp[i][j]=ans;
    }
    public boolean pallindrome(String s,int i,int j){
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