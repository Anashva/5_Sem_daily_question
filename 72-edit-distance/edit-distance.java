class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return dis(word1,word2,0,0,dp);
    }
    public int dis(String w1,String w2,int i,int j,int[][]dp){
        if(i==w1.length()){
            return w2.length()-j;
        }
        if(j==w2.length()){
            return w1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(w1.charAt(i)==w2.charAt(j)){
            ans=dis(w1,w2,i+1,j+1,dp);
        }
        else{
            int I=dis(w1,w2,i,j+1,dp);
            int D=dis(w1,w2,i+1,j,dp);
            int R=dis(w1,w2,i+1,j+1,dp);
            ans=Math.min(I,Math.min(R,D))+1;
        }
        return dp[i][j]=ans;
    }
}